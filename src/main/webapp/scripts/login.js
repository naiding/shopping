(function () {

    init();

    function init() {
    	$("#login-form").submit(function (event) {
			event.preventDefault();
			var form = $(this);
			
			if (!form.hasClass('fupload')) {
				$.ajax({
					type : form.attr('method'),
					url : form.attr('action'),
					data : form.serialize()
				}).success(function(result, status, xhr) {
					if (xhr.status === 200) {
						window.location.href = ("profile.html");
					}
				}).error(function(xhr, status, error) {
					$("#info").html("bad");
				});
			}
			
		});
    }
    
    
	
})();