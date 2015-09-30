





</style>

<div class="page-content">
	<div class="page-subheading page-subheading-md">
		<ol class="breadcrumb">
			<li><a href="javascript:;">Thông tin </a></li>
			<li><a href="javascript:;">Maps</a></li>
			<li class="active"><a href="javascript:;">Quảng Bình maps</a></li>
		</ol>
	</div>
	<section class="panel">
		<div class="panel-body">
			<div class="page-heading page-heading-md">
				<h2>Thông tin thời tiết Quảng Bình</h2>
			</div>


				<h5> <b>Thủ thuật: </b>Nhấn chuột phải để chọn nhanh địa điểm, hoặc chọn từng địa điểm trên bản đồ  </h5>

			<script type="text/javascript"
				src="http://maps.google.com/maps/api/js?sensor=false"></script>
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/static/js/ContextMenu.js"></script>

			<script>
		
			(window.google && window.google.maps)
					|| document
							.write('<script src="http:////maps.google.com/maps/api/js?sensor=false""><\/script>')
		</script>

			<div class="container-fluid-md">

				<div id="map" style="height: 600px; width: 100%"></div>
				<script type="text/javascript">
				
				function initialize() {

					var locations = ${listAllWeather};
					var urlLevel = ${pageContext.request.contextPath}+'';
					var mapDiv = document.getElementById('map');
					var map = new google.maps.Map(mapDiv, {

						center : new google.maps.LatLng(locations[1][4],
								locations[1][5]),
						zoom : 9,
						mapTypeId : google.maps.MapTypeId.SATELLITE,
						panControl: true,
						  panControlOptions: {
						  position: google.maps.ControlPosition.LEFT_TOP
						},
						zoomControl: true,
						zoomControlOptions: {
						  style: google.maps.ZoomControlStyle.LARGE,
						  position: google.maps.ControlPosition.LEFT_TOP
						}
					});




					
										
				    var infowindow = new google.maps.InfoWindow();
				    var infowindowLocation; 
				    
				    var infowindowLocation = new google.maps.InfoWindow();
function addClickListener(marker,locations,i) {
						
						google.maps.event.addListener(marker, 'click', (function(marker, i) {
					        return function() {
					        	infowindowLocation.close();
						          infowindow.setContent(locations[i][0]+'</br>'+locations[i][10]);
					          infowindow.open(map, marker);
					        }
					      })(marker, i));
						
					}
							
					var marker, i;
					
					for (i = 0; i < locations.length; i++) {
						marker = new google.maps.Marker({

							position : new google.maps.LatLng(locations[i][4],locations[i][5]),  
							icon:locations[i][8],map: map
							
							
						});

							
						google.maps.event.addListener(marker, 'click', (function(marker, i) {
					        return function() {
					          infowindow.setContent(locations[i][0]+'</br>'+locations[i][10]);
					          infowindow.open(map, marker);
					        }
					      })(marker, i));
					}


					//---
					
					//--
//					create the ContextMenuOptions object
var latPoint ;
									var contextMenuOptions = {};
									contextMenuOptions.classNames = {
										menu : 'context_menu',
										menuSeparator : 'context_menu_separator'
									};

									//	create an array of ContextMenuItem objects
									var menuItems = [];
									
									for (var icount = 0 ; icount<locations.length; icount++)
										{ 
										menuItems.push({
											className : 'context_menu_item',
											eventName : icount,
											label :locations[icount][0]
										});
										}
									
									//	a menuItem with no properties will be rendered as a separator
									
									contextMenuOptions.menuItems = menuItems;

									//	create the ContextMenu object
									var contextMenu = new ContextMenu(map, contextMenuOptions);

									//	display the ContextMenu on a Map right click
									google.maps.event.addListener(map, 'rightclick', function(
											mouseEvent) {
										contextMenu.show(mouseEvent.latLng);
									});

									//	listen for the ContextMenu 'menu_item_selected' event
									google.maps.event.addListener(contextMenu,
											'menu_item_selected', function(latLng, eventName) {
												//	latLng is the position of the ContextMenu
												//	eventName is the eventName defined for the clicked ContextMenuItem in the ContextMenuOptions
												 latPoint  = new google.maps.LatLng(locations[eventName][4],locations[eventName][5]); //Makes a latlng	

											
												marker.setPosition( new google.maps.LatLng(locations[eventName][4],locations[eventName][5] ) );
										        map.setZoom(17);
										        map.panTo( new google.maps.LatLng(locations[eventName][4],locations[eventName][5] ) );
										        infowindowLocation = new google.maps.InfoWindow();
										     
										        infowindowLocation.setContent(locations[eventName][0]);
										        infowindowLocation.open(map,marker);	
												addClickListener(marker,locations,eventName);
										        
																					      	
											});

									//--						
															
					
				

				}
				

				google.maps.event.addDomListener(window, 'load', initialize);
			</script>
			</div>

		</div>
</div>
</div>
</section>
<script src="static/assets/libs/jquery/jquery.min.js"></script>
<script src="static/assets/bs3/js/bootstrap.min.js"></script>
<script src="static/assets/plugins/jquery-navgoco/jquery.navgoco.js"></script>
<script src="static/js/main.js"></script>

<!--[if lt IE 9]>
        <script src="static/assets/plugins/flot/excanvas.min.js"></script>
        <![endif]-->
<script src="static/assets/plugins/jquery-sparkline/jquery.sparkline.js"></script>



</body>
</html>
