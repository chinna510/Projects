function loadpage(text){
	
	if (text === 'activity'){
		$("#content").attr("src", "activity.html");
	};
	if (text === 'dashboardsummary'){
		$("#content").attr("src", "dashboardsummary.html");
		
	};
	if (text === 'dashboardresources'){
		$("#content").attr("src", "dashboardresources.html");
	};
	if (text === 'applicationsummary'){
		$("#content").attr("src", "applicationsummary.html");
	};
	
	if (text === 'applicationwebhooks'){
		$("#content").attr("src", "applicationwebhooks.html");
	};
	if (text === 'environments'){
		$("#content").attr("src", "environments.html");
	};
	if (text === 'vpc'){  
		$("#content").attr("src", "vpc.html");
	};
	
	if (text === 'subnet'){
		$("#content").attr("src", "subnet.html");
	};
	if (text === 'vpn'){
		$("#content").attr("src", "vpn.html");
	};
	if (text === 'acl'){
		$("#content").attr("src", "acl.html");
	};
	if (text === 'firewall'){
		$("#content").attr("src", "firewall.html");
	};
	if (text === 'certificates'){
		$("#content").attr("src", "certificates.html");
		
	};
	          /*policies*/
	if (text === 'scalingandrecovery'){
		$("#content").attr("src", "scalingandrecovery.html");
	};
	if (text === 'hostscaling'){
		$("#content").attr("src", "hostscaling.html");
	};
	if (text === 'serviceaffinities'){
		$("#content").attr("src", "serviceaffinities.html");
	};
	if (text === 'resourceSelection'){
		$("#content").attr("src", "resourceselection.html");
	};
	if (text === 'environmentTypes'){
		$("#content").attr("src", "environmenttypes.html");
	};
	if (text === 'containertype'){
		$("#content").attr("src", "containertype.html");
	};
	if (text === 'cloudprovider'){
		$("#content").attr("src", "cloudprovider.html");
	};
	if (text === 'storage'){
		$("#content").attr("src", "storage.html");
	};
	if (text === 'imageregistry'){
		$("#content").attr("src", "imageregistry.html");
	};
	if (text === 'logserver'){
		$("#content").attr("src", "logserver.html");
	};
	if (text === 'errordiagnosis'){
		$("#content").attr("src", "errordiagnosis.html");
	};
	if (text === 'allhost'){
		$("#content").attr("src", "allhost.html");
	};
	
}; 
