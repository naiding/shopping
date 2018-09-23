(function () {

    init();

    function init() {
		$.ajax({
			url : "./user/login",		
			type : "GET",
		}).success(function(result, status, xhr) {
			if (xhr.status === 200) {
				login(result["user_id"]);
			}
		}).error(function(xhr, status, error) {
			$("#info").html("bad");
		});
    }
    
    function login(user_id) {
    	$.ajax({
			url : "./user/profile/" + user_id,		
			type : "GET",
		}).success(function(result, status, xhr) {
			if (xhr.status === 200) {
				$("#info").html(JSON.stringify(result));
			}
		}).error(function(xhr, status, error) {
			$("#info").html("no profile");
		});
    }
	
})();