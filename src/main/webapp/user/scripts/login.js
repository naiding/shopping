(function () {

    init();

    function init() {
    	$("#login-form").submit(function (event) {
			event.preventDefault();
			var form = $(this);
			
			if (!form.hasClass('fupload')) {
				$.ajax({
					url : "../api/user/login",
					type : "POST",
					data : form.serialize()
				}).success(function(result, status, xhr) {
					if (xhr.status === 200) {
						window.location.href = ("./profile.html");
					}
				}).error(function(xhr, status, error) {
					$("#info").html("bad");
				});
			}
			
		});
    }
})();