

<div class="page-content">
	<div class="page-subheading page-subheading-md">
		<ol class="breadcrumb">
			<li><a href="javascript:;">Thông tin </a></li>
			<li><a href="javascript:;">Maps</a></li>
			<li class="active"><a href="javascript:;">Quảng Bình Maps</a></li>
		</ol>
	</div>
	<div class="page-heading page-heading-md">
		<h2>Bản đồ phân bố và quy hoạch rừng đến năm 2020</h2>
	</div>



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

		<div id="map" style="height: 900px; width: 100%"></div>
					<h5> <b>Thủ thuật: </b>Nhấn chuột phải để chọn nhanh địa điểm, hoặc chọn từng địa điểm trên bản đồ  </h5>
		
		<script type="text/javascript">

			<script type="text/javascript"
				src="http://maps.google.com/maps/api/js?sensor=false"></script>
		<script>
				(window.google && window.google.maps)
						|| document
								.write('<script src="http:////maps.google.com/maps/api/js?sensor=false""><\/script>')
			</script>

		<div class="container-fluid-md">

			<div id="map" style="height: 900px; width: 100%"></div>
			
			<script type="text/javascript">
					function initialize() {

						var locations = ${listLocation};
						var forest;
						var mapDiv = document.getElementById('map');
						var map = new google.maps.Map(mapDiv, {

							center : new google.maps.LatLng(locations[1][0],
									locations[1][1]),
							zoom : 10,
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
					    var infowindowLocation = new google.maps.InfoWindow();
					    
								
						var marker, i;
						function addClickListener(marker,locations,i) {
							
							google.maps.event.addListener(marker, 'click', (function(marker, i) {
						        return function() {
						        	infowindowLocation.close();
							          infowindow.setContent("Địa điểm: "+locations[i][3]+'<br> Diện tích rừng: '+locations[i][4]+" ha");
						          infowindow.open(map, marker);
						        }
						      })(marker, i));
						      
							
						}
						
						for (i = 0; i < locations.length; i++) {
							marker = new google.maps.Marker({

								position : new google.maps.LatLng(locations[i][0],locations[i][1]),map: map
								
							});
							google.maps.event.addListener(marker, 'click', (function(marker, i) {
						        return function() {
									infowindowLocation.close();
							        
						          infowindow.setContent("Địa điểm: "+locations[i][3]+'<br> Diên tích rừng: '+locations[i][4]+" ha");
						          infowindow.open(map, marker);
						        }
						      })(marker, i));
							forest  = new google.maps.Circle({
								  center:new google.maps.LatLng(locations[i][0],
											locations[i][1]),
								  radius:0.1*locations[i][4],
								  strokeColor:"#0000FF",
								  strokeOpacity:0.8,
								  strokeWeight:2,
								  fillColor:"#0000FF",
								  fillOpacity:0.4
								  });

							forest.setMap(map);
								
						}
						//--
//						create the ContextMenuOptions object
	      
				var latPoint;
					var contextMenuOptions = {};
					contextMenuOptions.classNames = {
						menu : 'context_menu',
						menuSeparator : 'context_menu_separator'
					};

					//	create an array of ContextMenuItem objects
					var menuItems = [];

					for (var icount = 0; icount < locations.length; icount++) {
						menuItems.push({
							className : 'context_menu_item',
							eventName : icount,
							label : locations[icount][3]
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
                                                marker.setPosition( new google.maps.LatLng(locations[eventName][0],locations[eventName][1] ) );
										        map.setZoom(12);
										        map.panTo( new google.maps.LatLng(locations[eventName][0],locations[eventName][1] ) );
										        infowindowLocation.open(map, marker);
												infowindowLocation.setContent(locations[eventName][3]);
						
												addClickListener(marker,locations,eventName);
												
												
										        
										        
								
							
							});

					//--						

				}

				google.maps.event.addDomListener(window, 'load', initialize);
			</script>

		</div>

	</div>
</div>
<script src="static/assets/libs/jquery/jquery.min.js"></script>
<script src="static/assets/bs3/js/bootstrap.min.js"></script>
<script src="static/assets/plugins/jquery-navgoco/jquery.navgoco.js"></script>
<script src="static/js/main.js"></script>

<!--[if lt IE 9]>
        <script src="static/assets/plugins/flot/excanvas.min.js"></script>
        <![endif]-->
<script src="static/assets/plugins/jquery-sparkline/jquery.sparkline.js"></script>
<script src="static/demo/js/demo.js"></script>



</body>
</html>
