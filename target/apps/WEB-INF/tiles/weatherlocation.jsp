


	<div class="page-content">
		<div class="page-subheading page-subheading-md">
			<ol class="breadcrumb">
				<li><a href="javascript:;">Thông tin </a></li>
				<li><a href="javascript:;">Maps</a></li>
				<li class="active"><a href="javascript:;">Quảng Bình Maps</a></li>
			</ol>
		</div>
		<div class="page-heading page-heading-md">
			<h2>Tính mức cảnh báo cho địa phương </h2>
		</div>
					<h5> <b>Thủ thuật: </b>Nhấn chuột phải để chọn nhanh địa điểm, hoặc chọn từng địa điểm trên bản đồ  </h5>
			<a href="#note"> <b> Thông tin về các mức cảnh báo:</b></a>
</br>

		<script type="text/javascript"
			src="http://maps.google.com/maps/api/js?sensor=false"></script>
						        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/ContextMenu.js"></script>
			
		<script>
			(window.google && window.google.maps)
					|| document
							.write('<script src="http:////maps.google.com/maps/api/js?sensor=false""><\/script>')
		</script>

		<div class="container-fluid-md">

			<div id="map" style="height: 700px; width: 100%"></div>
	
			<script type="text/javascript">
			
				function initialize() {

					var locations = ${weatherlocation};
					var mapDiv = document.getElementById('map');
					var map = new google.maps.Map(mapDiv, {

						center : new google.maps.LatLng(locations[1][4],
								locations[1][5]),
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
						          infowindow.setContent(locations[i][0]+"</br>Mức cảnh báo cháy : "+locations[i][6]+'</br><img src= '+locations[i][8] +'>'+'<br> Nhiệt độ:'+locations[i][1]+" C </br>"+"Mô tả: "+locations[i][9]);
					          infowindow.open(map, marker);
					        }
					      })(marker, i));
						
					}
					
					for (i = 0; i < locations.length; i++) {
						marker = new google.maps.Marker({

							position : new google.maps.LatLng(locations[i][4],locations[i][5]),icon:'/static/images/level/level'+locations[i][6]+'.png',map: map
							,map: map
							
						});
						google.maps.event.addListener(marker, 'click', (function(marker, i) {
					        return function() {
					          infowindow.setContent(locations[i][0]+"</br> Mức cảnh báo cháy : "+locations[i][6]+'</br><img src= '+locations[i][8] +'>'+'<br> Nhiệt độ:'+locations[i][1]+" C </br>"+"Mô tả: "+locations[i][9]);
					          infowindow.open(map, marker);
					        }
					      })(marker, i));
					}
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
										        infowindowLocation =  new google.maps.InfoWindow();
									
												infowindowLocation.setContent(locations[eventName][0]);
												infowindowLocation.open(map,marker);	
										        addClickListener(marker,locations,eventName);
												
													
																					      	
											});

									//--
					

				}

				google.maps.event.addDomListener(window, 'load', initialize);
			</script>
		</div>
<div id="note">
<B> Dữ liệu được cập nhật tự động.<br>
Chú thích:
<ul><li>
<font color ="green">Mức báo động 1: Không có khả năng phát sinh cháy rừng</font></br></li>
<li><font color ="green">Mức báo động 2: Ít có khả năng phát sinh cháy rừng</font></br></li>
<li><font color ="orange">Mức báo động 3: Có nhiều khả năng phát sinh cháy rừng</font></br></li>
<li><font color ="red">Mức báo động 4: Rất có khả năng phát sinh cháy rừng</font></br></li>
</ul> 
</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/static/assets/libs/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/bs3/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/plugins/jquery-navgoco/jquery.navgoco.js"></script>
<script src="${pageContext.request.contextPath}/static/js/main.js"></script>

<!--[if lt IE 9]>
        <script src="${pageContext.request.contextPath}/static/assets/plugins/flot/excanvas.min.js"></script>
        <![endif]-->
<script src="${pageContext.request.contextPath}/static/assets/plugins/jquery-sparkline/jquery.sparkline.js"></script>
<script src="${pageContext.request.contextPath}/static/demo/js/demo.js"></script>



</body>
</html>
