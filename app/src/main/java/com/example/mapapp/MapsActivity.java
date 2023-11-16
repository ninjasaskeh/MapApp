package com.example.mapapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapapp.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private static final int CWhite = 0xfffafafa;
    private static final int COLOR_WHITE_ARGB = 0xffffffff;
    private static final int COLOR_DARK_GREEN_ARGB = 0xff388E3C;
    private static final int COLOR_LIGHT_GREEN_ARGB = 0xff81C784;
    private static final int CDark_Blue = 0xff00d2ff;
    private static final int CLight_Blue = 0xff73e6ff;
    private static final int POLYGON_STROKE_WIDTH_PX = 5;
    private static final int COLOR_BLACK_ARGB = 0xff000000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //petir
        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(
                        new LatLng(-4.127799,105.2737407),
                        new LatLng(-4.795930,104.965922),
                        new LatLng(-4.642643,105.647519),
                        new LatLng(-5.550893,105.592509)
                        ));

        polyline1.setTag("A");
        polyline1.setColor(CWhite);
        stylePolyline(polyline1);

        //batas jawa
        Polyline polyline2 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(
                        new LatLng(-6.398362,108.416458),
                        new LatLng(-6.908384,108.660740),
                        new LatLng(-7.055600,109.007035),
                        new LatLng(-7.647983,109.246015),
                        new LatLng(-7.637094,109.125087),
                        new LatLng(-7.784068,108.998661)
                ));
        polyline2.setTag("B");
        stylePolyline(polyline2);

        //ijo
        Polygon polygon1 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(-6.128211,107.057952),
                        new LatLng(-6.077251,107.126536),
                        new LatLng(-6.102386,107.226914),
                        new LatLng(-6.154273,107.305243),
                        new LatLng(-6.275777,107.275011),
                        new LatLng(-6.266222,107.097741)
                        ));

        polygon1.setTag("alpha");
        stylePolygon(polygon1);

        //oren
        Polygon polygon2 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(-4.918847,103.594614),
                        new LatLng(-4.804184,103.835575),
                        new LatLng(-4.844937,104.344447),
                        new LatLng(-4.347791,104.402527),
                        new LatLng(-3.908174,105.255909),
                        new LatLng(-3.736648,105.342400),
                        new LatLng(-4.160287,105.832084),
                        new LatLng(-5.905141,105.739240),
                        new LatLng(-5.442261,105.280873),
                        new LatLng(-5.834104,105.195202),
                        new LatLng(-5.544401,104.552081),
                        new LatLng(-5.948851,104.716984),
                        new LatLng(-5.640794,104.302158)
                ));
        polygon2.setTag("beta");
        stylePolygon(polygon2);

        //Nambahin Marker
        LatLng jababeka = new LatLng(-6.276829, 107.144124);
        mMap.addMarker(new MarkerOptions().position(jababeka).title("Marker in Jababeka"));
        mMap.setMaxZoomPreference(300);


    }



    private void stylePolyline(Polyline polyline) {
    }

    private void stylePolygon(Polygon polygon) {
        String type = "";
        // Get the data object stored with the polygon.
        if (polygon.getTag() != null) {
            type = polygon.getTag().toString();
        }

        List<PatternItem> pattern = null;
        int strokeColor = COLOR_BLACK_ARGB;
        int fillColor = COLOR_WHITE_ARGB;

        switch (type) {

            case "alpha":
                strokeColor = COLOR_DARK_GREEN_ARGB;
                fillColor = COLOR_LIGHT_GREEN_ARGB;
                break;

            case "beta":
                strokeColor = CDark_Blue;
                fillColor = CLight_Blue;
                break;
        }

        polygon.setStrokePattern(pattern);
        polygon.setStrokeWidth(POLYGON_STROKE_WIDTH_PX);
        polygon.setStrokeColor(strokeColor);
        polygon.setFillColor(fillColor);
    }
}