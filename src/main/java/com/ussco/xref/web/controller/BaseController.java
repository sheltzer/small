package com.ussco.xref.web.controller;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.FieldError;

/**
 * Base controller class to hold common injections needed by all controller
 * classes and to contain some base functionality.
 *
 * @author mike.nolan
 *
 */
public class BaseController {
	private final static Logger LOG = Logger.getLogger(BaseController.class);


	@Autowired
	protected MessageSource messageSource;

	public void setMessageSource(final MessageSource messageSource) {
		this.messageSource = messageSource;
	}


	/**
	 * Helper method for resolving DefaultMessageSourceResolvable into a message
	 * from the MessageSource. We are simply looping through them until we find a
	 * match. When not match is found, a NoSuchMessageException is thrown.
	 *
	 * @param DefaultMessageSourceResolvable
	 * @return String Message
	 */
	protected String resolveDefaultMessageSourceResolvableToMessage(DefaultMessageSourceResolvable defaultMessageSourceResolvable){
		final String METHOD = "resolveErrorToMessageSource";
		if (LOG.isTraceEnabled()) {
			LOG.trace(METHOD + " - entry");
		}

		String result = null;

		// If you call MessageSource#getMessage without a default message, it
		// will throw an exception when there is no match.
		// Thus we are passing our own default message to ensure we get a value
		// and use that to determine if we truly had a value
		// in the message source. This is being done for efficiency reasons. It
		// is assumed that no message key's value
		// would be 'x-default-x'.
		final String defaultMessage = "x-default-x";

		codeLoop: for (String code : defaultMessageSourceResolvable.getCodes()) {
			final String message = this.messageSource.getMessage(code,
					defaultMessageSourceResolvable.getArguments(), defaultMessage, Locale.US);
			if (!defaultMessage.equals(message)) {
				result = message;
				break codeLoop;
			}
		}

		if (LOG.isTraceEnabled()) {
			LOG.trace(METHOD + " - exit");
		}

		return result;
	}

	/**
	 * Helper method for resolving the field error into a message from the
	 * MessageSource.
	 *
	 * @param FieldError
	 * @return String Message
	 */
	protected String resolveFieldErrorToMessageSource(
			final FieldError fieldError) {
		final String METHOD = "resolveFieldErrorToMessageSource";
		if (LOG.isTraceEnabled()) {
			LOG.trace(METHOD + " - entry");
		}

		String result = resolveDefaultMessageSourceResolvableToMessage(fieldError);

		if (result == null) {
			throw new NoSuchMessageException("FieldError for "
					+ fieldError.getField() + " does not have a valid message.");
		}
		if (LOG.isTraceEnabled()) {
			LOG.trace(METHOD + " - exit");
		}
		return result;
	}

	/**
	 * Helper method for resolving the error into a message from the
	 * MessageSource. We are simply looping through them until we find a
	 * match. When not match is found, a NoSuchMessageException is thrown.
	 *
	 * @param ObjectError
	 * @return String Message
	 */
//	protected String resolveWarningToMessageSource(ObjectWarning objectWarning){
//		final String METHOD = "resolveWarningToMessageSource";
//		if (LOG.isTraceEnabled()) {
//			LOG.trace(METHOD + " - entry");
//		}
//
//		String result = resolveDefaultMessageSourceResolvableToMessage(objectWarning);
//
//		if (LOG.isTraceEnabled()) {
//			LOG.trace(METHOD + " - exit");
//		}
//
//		return result;
//	}


//	/**
//	 * Helper method to determine if a user has a particular authority
//	 *
//	 * @return boolean
//	 */
//	protected boolean userHasAuthority(String authorityIn) {
//		final String METHOD = "userHasAuthority";
//		if (LOG.isTraceEnabled()) {
//			LOG.trace(METHOD + " - entry");
//		}
//		Collection<? extends GrantedAuthority> authorities = getUserDetails()
//				.getAuthorities();
//
//		for (GrantedAuthority authority : authorities) {
//			if (authority.getAuthority().equalsIgnoreCase(authorityIn)) {
//				return true;
//			}
//		}
//		if (LOG.isTraceEnabled()) {
//			LOG.trace(METHOD + " - exit");
//		}
//		return false;
//	}

//	/**
//	 * Add error message to the MAV for the provided error code
//	 * @param ModelAndView mav
//	 * @param String code
//	 */
//	protected void addErrorMessage(final ModelAndView mav, final String code){
//		final String METHOD = "populateModelAndViewWithNotificationAndErrorMessages";
//		if (LOG.isTraceEnabled()) {
//			LOG.trace(METHOD + " - entry");
//		}
//
//		String message =  this.messageSource.getMessage(code, null, null, Locale.US);
//		mav.addObject(WebConst.ModelKey.ERROR_MESSAGE,  message);
//
//		if (LOG.isTraceEnabled()) {
//			LOG.trace(METHOD + " - exit");
//		}
//	}
//
//	protected void populateModelAndViewWithNotificationAndErrorMessages(
//			final ModelAndView mav,
//			final ServiceProcessingResponse<?> response) {
//		final String METHOD = "populateModelAndViewWithNotificationAndErrorMessages";
//		if (LOG.isTraceEnabled()) {
//			LOG.trace(METHOD + " - entry");
//		}
//
//		final ErrorsAndWarnings errorsAndWarnings = response.getProcessingErrorsAndWarnings();
//
//		// Set global error message from global error code
//		if(response.getGlobalErrorCode() != null){
//			response.setGlobalErrorMessage(this.messageSource.getMessage(response.getGlobalErrorCode(), null, response.getGlobalErrorMessage(), Locale.US));
//		}
//
//		// Set global notification message from global notification code
//		if(response.getGlobalNotificationCode() != null){
//			response.setGlobalNotificationMessage(this.messageSource.getMessage(response.getGlobalNotificationCode(), null, response.getGlobalNotificationMessage(), Locale.US));
//		}
//
//		if (errorsAndWarnings != null && !errorsAndWarnings.hasErrors()
//				&& StringUtils.isEmpty(response.getGlobalErrorMessage())) {
//
//			final String globalNotificationMessage = response.getGlobalNotificationMessage();
//
//			if (StringUtils.isNotEmpty(globalNotificationMessage)) {
//				mav.addObject(WebConst.ModelKey.PROCESSING_SUCCESS_MESSAGE,
//						globalNotificationMessage);
//			} // Omit the else, we only add the processing message if there was
//				// one
//		} else {
//
//			final String globalNotificationMessage = response
//					.getGlobalNotificationMessage();
//			if (StringUtils.isNotEmpty(globalNotificationMessage)) {
//				mav.addObject(WebConst.ModelKey.PROCESSING_SUCCESS_MESSAGE,
//						globalNotificationMessage);
//			} else if (StringUtils.isNotEmpty(response
//					.getGlobalErrorMessage())) {
//				mav.addObject(WebConst.ModelKey.ERROR_MESSAGE,
//						response.getGlobalErrorMessage());
//			}else if(response.getProcessingErrorsAndWarnings().hasGlobalErrors()){
//				mav.addObject(WebConst.ModelKey.ERROR_MESSAGE,
//						resolveDefaultMessageSourceResolvableToMessage(response.getProcessingErrorsAndWarnings().getGlobalError()));
//			}
//
//			if (errorsAndWarnings != null && errorsAndWarnings.hasErrors()) {
//				final Map<String, String> fieldErrorMap = new HashMap<String, String>();
//				final List<FieldError> fieldErrorList = errorsAndWarnings
//						.getFieldErrors();
//				for (final FieldError fieldError : fieldErrorList) {
//					String message = this
//							.resolveFieldErrorToMessageSource(fieldError);
//					fieldErrorMap.put(fieldError.getField(), message);
//				}
//				mav.addObject(WebConst.ModelKey.FIELD_ERRORS, fieldErrorMap);
//			}
//		}
//
//		if(!response.isWarningsIgnored() && errorsAndWarnings != null && errorsAndWarnings.hasWarnings()){
//			final List<String> warningMessages = new LinkedList<String>();
//			for(ObjectWarning warning : errorsAndWarnings.getWarnings()){
//				warningMessages.add(resolveDefaultMessageSourceResolvableToMessage(warning));
//			}
//			mav.addObject(WebConst.ModelKey.WARNINGS, warningMessages);
//		}
//
//		if (LOG.isTraceEnabled()) {
//			LOG.trace(METHOD + " - exit");
//		}
//	}
//
//	protected void populateModelAndViewForContentDashboardServiceProcessingResponse(final ModelAndView mav, final ContentDashboardServiceProcessingResponse<String> response) {
//		//TODO: finish coding
//		final String METHOD = "populateModelAndViewForContentDashboardServiceProcessingResponse";
//		if (LOG.isTraceEnabled()) {
//			LOG.trace(METHOD + " - entry");
//		}
//
//		mav.addObject(WebConst.ModelKey.CONTENT_DASHBOARD_ACTION_RESULTS, response.getResults());
//
//		if(response.isAllSuccess()) {
//			final String message = this.messageSource.getMessage(response.getGlobalNotificationCode(), new Object[0], Locale.US);
//			mav.addObject(WebConst.ModelKey.PROCESSING_SUCCESS_MESSAGE, message);
//		}
//		else {
//			String errorCode = response.getGlobalErrorCode();
//			Object[] messageParams;
//
//			if(response.isSuccessAndFail()) {
//				//this requires two parameters: 1) number of successes 2) total submitted
//				messageParams = new Object[] {response.getNumberOfSuccesses(), response.getNumberOfSuccesses() + response.getNumberOfFailures()};
//			}
//			else {
//				messageParams = new Object[0];
//			}
//
//			final String message = this.messageSource.getMessage(errorCode,	messageParams, Locale.US);
//			mav.addObject(WebConst.ModelKey.ERROR_MESSAGE, message);
//		}
//
//		if (LOG.isTraceEnabled()) {
//			LOG.trace(METHOD + " - exit");
//		}
//	}
}
