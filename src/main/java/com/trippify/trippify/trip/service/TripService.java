package com.trippify.trippify.trip.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trippify.trippify.common.model.StatusResponse;
import com.trippify.trippify.trip.dao.IDestinationDao;
import com.trippify.trippify.trip.dao.ITripDao;
import com.trippify.trippify.trip.model.BudgetVO;
import com.trippify.trippify.trip.model.DestinationVO;
import com.trippify.trippify.trip.model.ParticularsVO;
import com.trippify.trippify.trip.model.TripDetailsVO;
import com.trippify.trippify.trip.model.reponse.TripRest;
import com.trippify.trippify.trip.model.reponse.TripRestResponse;
import com.trippify.trippify.trip.model.request.CreateTripRest;
import com.trippify.trippify.trip.view.DestinationView;
import com.trippify.trippify.trip.view.TripView;

@Transactional
@Service
public class TripService {

	@Autowired
	public ITripDao tripDao;

	@Autowired
	public IDestinationDao destDao;

	public StatusResponse createTrip(CreateTripRest tripInput) {
		StatusResponse response = new StatusResponse();

		List<DestinationView> destinationList = new ArrayList<>();
		TripView newTripObj = new TripView();
		newTripObj.setName(tripInput.getParticulars().getName());
		newTripObj.setEmail(tripInput.getParticulars().getEmail());
		newTripObj.setAttractionBudget(tripInput.getBudget().getAttractionBudget());
		newTripObj.setFlightBudget(tripInput.getBudget().getFlightBudget());
		newTripObj.setFoodBudget(tripInput.getBudget().getFoodBudget());
		newTripObj.setHotelBudget(tripInput.getBudget().getHotelBudget());
		newTripObj.setOtherBudget(tripInput.getBudget().getOtherBudget());
		newTripObj.setTotalBudget(tripInput.getBudget().getTotalBudget());
		newTripObj.setTransportBudget(tripInput.getBudget().getTransportBudget());
		newTripObj.setNoOfDestinations(tripInput.getTripDetails().getNoOfDestinations());

		newTripObj.setCreatedBy("VINCENT");
		newTripObj.setCreatedDt(LocalDateTime.now());

		tripInput.getTripDetails().getDestinations().forEach(destination -> {

			DestinationView destinationView = new DestinationView();
			destinationView.setCtryName(destination.getCtryName());
			destinationView.setCityName(destination.getCityName());
			destinationView.setDays(destination.getNoOfTripDays());
			destinationView.setCreatedBy("VINCENT");
			destinationView.setCreatedDt(LocalDateTime.now());

			try {
				Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse(destination.getDateFromStr());
				Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse(destination.getDateToStr());
				destinationView.setDateFrom(dateFrom);
				destinationView.setDateTo(dateTo);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				response.setStatusCode(1);
				response.setResultMessage("Exception parsing dateFrom or dateTo");
				e.printStackTrace();
			}

			destinationList.add(destinationView);
		});

		newTripObj.setDestinations(destinationList);

		if (response.getStatusCode() == 0) {
			this.tripDao.save(newTripObj);
			response.setResultMessage("Trip was created successfully.");
		}

		return response;
	}

	public TripRestResponse findAllTrips(int page, int size) {

		Pageable pageable = PageRequest.of(page - 1, size);

		TripRestResponse response = new TripRestResponse();
		List<TripRest> tripRestList = new ArrayList<>();
		Page<TripView> tripViewList = this.tripDao.findAll(pageable);
		long totalRec = this.tripDao.count();

		tripViewList.forEach(trip -> {
			TripRest tripRest = new TripRest();

			ParticularsVO particularVO = new ParticularsVO();
			BudgetVO budgetVO = new BudgetVO();
			TripDetailsVO tripDetailsVO = new TripDetailsVO();

			tripRest.setId(trip.getId());
			particularVO.setName(trip.getName());
			particularVO.setEmail(trip.getEmail());
			budgetVO.setAttractionBudget(trip.getAttractionBudget());
			budgetVO.setFlightBudget(trip.getFlightBudget());
			budgetVO.setFoodBudget(trip.getFoodBudget());
			budgetVO.setHotelBudget(trip.getHotelBudget());
			budgetVO.setOtherBudget(trip.getOtherBudget());
			budgetVO.setTotalBudget(trip.getTotalBudget());
			budgetVO.setTransportBudget(trip.getTransportBudget());
			tripDetailsVO.setNoOfDestinations(trip.getNoOfDestinations());

			List<DestinationView> destinationViewList;
			destinationViewList = this.destDao.findAllByTripViewId(trip.getId());
			List<DestinationVO> destinationVOList = new ArrayList<>();
			destinationViewList.forEach(destination -> {
				DestinationVO destinationVO = new DestinationVO();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				destinationVO.setCtryName(destination.getCtryName());
				destinationVO.setCityName(destination.getCityName());
				destinationVO.setDateFromStr(formatter.format(destination.getDateFrom()));
				destinationVO.setDateToStr(formatter.format(destination.getDateTo()));
				destinationVO.setNoOfTripDays(destination.getDays());
				destinationVOList.add(destinationVO);
			});

			tripDetailsVO.setDestinations(destinationVOList);

			tripRest.setParticulars(particularVO);
			tripRest.setBudget(budgetVO);
			tripRest.setTripDetails(tripDetailsVO);
			tripRest.setCreatedBy(trip.getCreatedBy());
			tripRest.setCreatedDt(trip.getCreatedDt());

			tripRestList.add(tripRest);
		});

		PageImpl<TripRest> tripViewPage = new PageImpl<TripRest>(tripRestList, pageable, totalRec);

		response.setTripList(tripViewPage);

		return response;
	}

	public StatusResponse deleteTrip(Long id) {
		StatusResponse response = new StatusResponse();

		this.tripDao.deleteById(id);
		response.setResultMessage("Trip ID: " + id + " was deleted successfully.");

		return response;
	}
}
