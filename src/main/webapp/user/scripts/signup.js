(function () {

    init();

    function init() {
    	$("#signup-form").submit(function (event) {
			event.preventDefault();
			var form = $(this);
			
			if (!form.hasClass('fupload')) {
				$.ajax({
					url : "../api/user/register",
					type : "POST",
					data : form.serialize()
				}).success(function(result, status, xhr) {
					if (xhr.status === 200) {
						window.location.href = ("./login.html");
					}
				}).fail(function(jqXHR, textStatus, errorThrown) {
					$("#info").html("bad");
				});
			}
			
		});
    }
	
})();