(function () {

    init();

    function init() {
    	$("#signup-form").submit(function (event) {
			event.preventDefault();
			var form = $(this);
			
			if (!form.hasClass('fupload')) {
				$.ajax({
					type : form.attr('method'),
					url : form.attr('action'),
					data : form.serialize()
				}).success(function(result, status, xhr) {
					if (xhr.status === 200) {
						window.location.href = ("login.html");
					}
				}).fail(function(jqXHR, textStatus, errorThrown) {
					$("#info").html("bad");
				});
			}
			
		});
    }
	
})();