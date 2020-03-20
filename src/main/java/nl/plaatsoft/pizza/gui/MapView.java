package nl.plaatsoft.pizza.gui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import nl.plaatsoft.pizza.component.MyBanner;
import nl.plaatsoft.pizza.component.MyFooter;
import nl.plaatsoft.pizza.component.MyTitle;

//import org.osgeo.proj4j.BasicCoordinateTransform;
//import org.osgeo.proj4j.CRSFactory;
//import org.osgeo.proj4j.CoordinateReferenceSystem;
//import org.osgeo.proj4j.ProjCoordinate;

import org.vaadin.addon.vol3.OLMap;
import org.vaadin.addon.vol3.OLMapOptions;
import org.vaadin.addon.vol3.OLView;
import org.vaadin.addon.vol3.OLViewOptions;
import org.vaadin.addon.vol3.client.OLCoordinate;
import org.vaadin.addon.vol3.client.OLExtent;
import org.vaadin.addon.vol3.client.Projections;
import org.vaadin.addon.vol3.client.style.OLCircleStyle;
import org.vaadin.addon.vol3.client.style.OLStrokeStyle;
import org.vaadin.addon.vol3.client.style.OLStyle;
import org.vaadin.addon.vol3.feature.OLFeature;
import org.vaadin.addon.vol3.feature.OLPoint;
import org.vaadin.addon.vol3.layer.OLLayer;
import org.vaadin.addon.vol3.layer.OLTileLayer;
import org.vaadin.addon.vol3.layer.OLVectorLayer;
import org.vaadin.addon.vol3.source.OLOSMSource;
import org.vaadin.addon.vol3.source.OLVectorSource;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Basic map view
 */
public class MapView extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;
	
	protected OLMap map;
    private static final Logger logger= Logger.getLogger(MapView.class.getName());

    NavigatorUI navigator;
    
    public MapView(NavigatorUI navigator) {
    	
    	this.navigator = navigator;
    	
        map=createMap();
        this.addViewChangeListener();
                
        // ----
        
        Panel panel = new Panel("");
	    panel.setSizeFull();
	     	     
	    VerticalLayout layout2 = new VerticalLayout();
	    layout2.setSpacing(true);
	    layout2.setMargin(true);
	     	     
	    layout2.addComponent(new MyTitle("Map"));
	    
	    layout2.addComponent(map);
	    
	    panel.setContent(layout2);
	    
	    // ----
	    
	    VerticalLayout layout = new VerticalLayout();
	    layout.setSpacing(false);
	    layout.setMargin(true);
	     
	    MyBanner banner = new MyBanner(navigator.getNavigator());
	     
	    layout.addComponent(banner.getLayout());
        layout.addComponent(panel);
	    layout.addComponent(MyFooter.getFooter());
	        
	    setCompositionRoot(layout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    protected OLMap createMap(){
                       
        // Style Start Point
        
        OLStrokeStyle stroke1 = new OLStrokeStyle();
        stroke1.color = "black";
        
        OLCircleStyle circleStyle1 = new OLCircleStyle();
        circleStyle1.radius = 2.0;
        circleStyle1.stroke = stroke1;
                
        OLStyle style1 = new OLStyle();
        style1.circleStyle = circleStyle1;
        
        // Style next point
        
        OLStrokeStyle stroke2 = new OLStrokeStyle();
        stroke2.color = "red";
        
        OLCircleStyle circleStyle2 = new OLCircleStyle();
        circleStyle2.radius = 2.0;
        circleStyle2.stroke = stroke2;
                
        OLStyle style2 = new OLStyle();
        style2.circleStyle = circleStyle2;
                
        // ----
        
        OLPoint point1  = new OLPoint(new OLCoordinate(0,0));
        
        OLFeature feature1 = new OLFeature();
        feature1.setGeometry(point1);
        feature1.setStyle(style1);
        
        // ----
        
        OLPoint point2  = new OLPoint(new OLCoordinate(1,1));
        
        OLFeature feature2 = new OLFeature();
        feature2.setGeometry(point2);
        feature2.setStyle(style2);
        
        // ----
        
        OLPoint point3  = new OLPoint(new OLCoordinate(2,2));
        
        OLFeature feature3 = new OLFeature();
        feature3.setGeometry(point3);
        feature3.setStyle(style2);
        
        // ----
        
        OLPoint point4  = new OLPoint(new OLCoordinate(3,3));
        
        OLFeature feature4 = new OLFeature();
        feature4.setGeometry(point4);
        feature4.setStyle(style2);
        
        // ----
        
        List<OLFeature> features = new ArrayList<OLFeature>();
        features.add(feature1);
        features.add(feature2);
        features.add(feature3);
        features.add(feature4);
        
        // ----
                
        OLLayer layer1 =new OLTileLayer(new OLOSMSource());
        layer1.setTitle("OpenStreetMapLayer");
        
        OLVectorSource vectorSource = new OLVectorSource();       
		vectorSource.addFeatures(features);
                
        OLLayer layer2 = new OLVectorLayer(vectorSource);
        layer2.setTitle("VectorLayer");
               
        OLMap map=new OLMap(new OLMapOptions().setShowOl3Logo(false).setInputProjection(Projections.EPSG3857));
        map.addLayer(layer1); 
        map.addLayer(layer2);
       
        OLViewOptions opts=new OLViewOptions();
        opts.setInputProjection(Projections.EPSG3857);
        OLView view=new OLView(opts);
        
        view.setZoom(5);
        view.setCenter(0,0);
        //view.setCenter(transformWGS84(52.0251262, 4.7358992));
              
        // ----
        
        map.setView(view);
        map.setWidth("100%");
        map.setHeight("700px");
        map.addClickListener(new OLMap.ClickListener() {
            @Override
            public void onClick(OLMap.OLClickEvent clickEvent) {
                System.out.println(clickEvent.toString());
            }
        }); 
        
        return map;
    }

    /*private OLCoordinate transformWGS84(double longtiude, double latitude) {
    	CRSFactory factory = new CRSFactory();
    	CoordinateReferenceSystem srcCrs = factory.createFromName("EPSG:4326");
    	CoordinateReferenceSystem dstCrs = factory.createFromName("EPSG:4141");

    	BasicCoordinateTransform transform = new BasicCoordinateTransform(srcCrs, dstCrs);

    	// Note these are x, y so lng, lat
    	ProjCoordinate srcCoord = new ProjCoordinate(longtiude, latitude);
    	ProjCoordinate dstCoord = new ProjCoordinate();

    	// Writes result into dstCoord
    	transform.transform(srcCoord, dstCoord); 
    	
    	return new OLCoordinate(dstCoord.x, dstCoord.y);
    }*/
    
    private void addViewChangeListener() {
        map.getView().addViewChangeListener(new OLView.ViewChangeListener() {
            @Override
            public void resolutionChanged(Double newResolution) {
                logger.info("resolution changed " + newResolution);
            }

            @Override
            public void rotationChanged(Double rotation) {
                logger.info("rotation changed " + rotation);
            }

            @Override
            public void centerChanged(OLCoordinate centerPoint) {
                logger.info("center changed " + centerPoint.toString());
            }

            @Override
            public void zoomChanged(Integer zoom) {
                logger.info("zoom changed " + zoom);
            }

            @Override
            public void extentChanged(OLExtent extent) {
                logger.info("extent changed " + extent.minX + "," + extent.minY + "," + extent.maxX + "," + extent.maxY);
            }
        });
    }
}