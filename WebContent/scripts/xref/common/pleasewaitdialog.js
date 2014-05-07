function PleaseWaitDialog(dialogText, dialogHeight, dialogWidth) {
	
	var self = this;
	self.dialog = $('#pleaseWaitDialog');
	self.textValue = (dialogText != null && dialogText != "") ? dialogText : "Please wait ...";
	
	self.buildDialogDisplay = function() {
		if (self.dialog.size() > 0) {
			self.dialog.remove();
		}
			
		self.dialog = $('<div>').attr('id', 'pleaseWaitDialog');

		var mainContentArea = $('#main');
		
		var container = $('<div>').addClass('waiting-container');
		var spinner = $('<div>').addClass('spinner');
		var text = $('<div>').addClass('waiting-text').text(self.textValue);
		
		container.append(text);
		container.append(spinner);
		self.dialog.append(container);
		//text.append(spinner);
		//self.dialog.append(text);
		
		mainContentArea.append(this.dialog);
		//Make sure the length of the text is the dialogWith - 75. This will allow room for the spinner
		var textWidth = dialogWidth - 75;
		$('#pleaseWaitDialog div.waiting-text').css({"width":textWidth});

		self.dialog.dialog({
			'autoOpen' : false,
			'closeOnEscape' : false,
			'height' : (dialogHeight != null) ? dialogHeight : 100,
			'modal' : true,
			'resizable' : false,
			'width' : (dialogWidth != null) ? dialogWidth : 250
		});
	};
	
	self.show = function() {
		
		self.buildDialogDisplay();
		self.dialog.dialog('open');
	};
	
	self.hide = function() {
		self.dialog.dialog('close');
	};
}