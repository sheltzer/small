/**
 * Copyright United Stationers Supply Company
 *
 * This material is confidential, proprietary product of
 * United Stationers Supply Co. for the sole and exclusive use
 * by United Stationers Supply Co. or an authorized dealer.
 *
 * United Stationers retains the exclusive right to compile and
 * publish this material. By accepting this material, you agree
 * to respect the confidential nature of this material and not
 * make copies of the whole or any part thereof, or distribute
 * the same, or divulge the contents of the materials to any
 * person not an authorized dealer or customer of United
 * Stationers Supply Co. without permission.
*/
package com.ussco.xref.web.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.ussco.xref.domain.MatchingCriteria;
import com.ussco.xref.exception.SystemException;
import com.ussco.xref.model.domain.BusinessUnit;
import com.ussco.xref.model.domain.MatchType;
import com.ussco.xref.model.domain.Reseller;
import com.ussco.xref.model.domain.XRefType;
import com.ussco.xref.to.matching.MatchingTO;
import com.ussco.xref.utils.XrefUtils;
import com.ussco.xref.web.WebConst;

/**
 * @author Sandy Heltzer
 *
 */
@Controller
@RequestMapping("/matching")
public class MatchingRequestController  extends BaseController {
	private final static Logger LOG = Logger.getLogger(MatchingRequestController.class);


	@RequestMapping(value="/display")
	public ModelAndView displayScreen() {
		final String METHOD = "displayScreen";
		if (LOG.isTraceEnabled()) { LOG.trace(METHOD + " - enter "); };

		ModelAndView mav = new ModelAndView(WebConst.View.MATCHING);

		if (LOG.isTraceEnabled()) { LOG.trace(METHOD + " - exit "); };
		return mav;
	}

	@RequestMapping(value="/loadDropDowns", method=RequestMethod.POST, produces=WebConst.ContentType.APP_JSON)
	public ModelAndView loadDropDowns() {
		final String METHOD = "loadDropDowns";
		if (LOG.isTraceEnabled()) { LOG.trace(METHOD + " - enter "); };

		ModelAndView mav = new ModelAndView(new MappingJacksonJsonView());
		mav.addObject(WebConst.ModelKey.RESELLER_OPTIONS, buildResellerCodeSet());
		mav.addObject(WebConst.ModelKey.MATCH_TYPE_OPTIONS, buildMatchTypeCodeSet());
		mav.addObject(WebConst.ModelKey.XREF_TYPE_OPTIONS, buildXrefTypeCodeSet());
		mav.addObject(WebConst.ModelKey.ADDITIONAL_FIELD_OPTIONS, XrefUtils.buildAdditionalFieldCodeSet());
		mav.addObject(WebConst.ModelKey.BUSINESS_UNIT_OPTIONS, buildBusinessUnitCodeSet());

		if (LOG.isTraceEnabled()) { LOG.trace(METHOD + " - exit "); };
		return mav;
	}

	@RequestMapping(value="/generateReport", method=RequestMethod.POST)
	public ModelAndView generateReportRequest(@ModelAttribute("matchingRequest") MatchingCriteria matchingRequest, BindingResult result) {
		final String METHOD = "generateReportRequest";
		if (LOG.isTraceEnabled()) { LOG.trace(METHOD + " - enter "); };

		MappingJacksonJsonView view = new MappingJacksonJsonView();
		final ModelAndView mav = new ModelAndView(view);


		try {
			MatchingTO matchRequest = buildMatchingObject(matchingRequest);

			//this.offlineHelper.scheduleExecution(matchRequest, null);
			mav.addObject(WebConst.ModelKey.PROCESSING_SUCCESS_MESSAGE, "Matching Request has been successfully submitted.  Please check the Request screen to monitor progress.  An e-mail will be generated when report is complete.");
		} catch (Exception e) {
			LOG.error("Could not schedule request", e);
			mav.addObject(WebConst.ModelKey.ERROR_MESSAGE, "The XRef scheduler experienced an error.  Please submit re-submit your request.");
		}

		if (LOG.isTraceEnabled()) { LOG.trace(METHOD + " - exit "); };
		return mav;
	}

	/**
	 * @param matchingCriteria
	 * @return
	 * @throws SystemException
	 */
	protected MatchingTO buildMatchingObject(MatchingCriteria matchingCriteria) throws Exception {
		MatchingTO matchRequest = new MatchingTO();
		//matchRequest.setRequestType(RequestTypeEnum.MATCHING);

		/*matchRequest.setEmailAddress(XrefUserDetailsUtil.getUserEmail());
		matchRequest.setUserId(XrefUserDetailsUtil.getUserID());
		matchRequest.setActiveOnly(matchingCriteria.getActiveOnly());
		matchRequest.setCompanyId(matchingCriteria.getBusinessUnit());
		matchRequest.setResellerCodes(matchingCriteria.getResellers());
		matchRequest.setXrefCodes(matchingCriteria.getXrefTypes());
		matchRequest.setMatchCodes(matchingCriteria.getMatchTypes());
		matchRequest.setExtraFields(matchingCriteria.getAdditionalFields());
		matchRequest.setOutputFileName(matchingCriteria.getOutputFileName());
		matchRequest.setOutputFileExtension(matchingCriteria.getOutputFormat());*/

		return matchRequest;
	}

	/**
	 * @return
	 */
	protected List<BusinessUnit> buildBusinessUnitCodeSet() {
		List<BusinessUnit> businessUnitList = new ArrayList<BusinessUnit>();

		BusinessUnit busUnit = new BusinessUnit();
		busUnit.setCode("01");
		busUnit.setName("Supply");
		businessUnitList.add(busUnit);

		busUnit = new BusinessUnit();
		busUnit.setCode("04");
		busUnit.setName("Lagasse");
		businessUnitList.add(busUnit);

		return businessUnitList;
	}

	/**
	 * @return
	 */
	protected List<Reseller> buildResellerCodeSet() {
		List<Reseller> xrefTypeList = new LinkedList<Reseller>();
		Reseller type = new Reseller();
		type.setCode("R1");
		type.setResellerName("R1 Description");
		xrefTypeList.add(type);

		type = new Reseller();
		type.setCode("R2");
		type.setResellerName("R2 Description");
		xrefTypeList.add(type);

		type = new Reseller();
		type.setCode("R3");
		type.setResellerName("R3 Description");
		xrefTypeList.add(type);
		return xrefTypeList;
	}

	/**
	 * @return
	 */
	protected List<MatchType> buildMatchTypeCodeSet() {
		List<MatchType> xrefTypeList = new LinkedList<MatchType>();
		MatchType type = new MatchType();
		type.setCode("M1");
		type.setDescription("M1 Description");
		xrefTypeList.add(type);

		type = new MatchType();
		type.setCode("M2");
		type.setDescription("M2 Description");
		xrefTypeList.add(type);

		type = new MatchType();
		type.setCode("M3");
		type.setDescription("M3 Description");
		xrefTypeList.add(type);
		return xrefTypeList;
	}

	/**
	 * @return
	 */
	protected List<XRefType> buildXrefTypeCodeSet() {
		List<XRefType> xrefTypeList = new LinkedList<XRefType>();
		XRefType type = new XRefType();
		type.setCode("X1");
		type.setDescription("X1 Description");
		xrefTypeList.add(type);

		type = new XRefType();
		type.setCode("X2");
		type.setDescription("X2 Description");
		xrefTypeList.add(type);

		type = new XRefType();
		type.setCode("X3");
		type.setDescription("X3 Description");
		xrefTypeList.add(type);
		return xrefTypeList;
	}

}
