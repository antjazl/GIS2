package com.app.mapasgis.mapasgis;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by bryan on 19/1/2017.
 */
public class GmapsClass extends Fragment implements OnMapReadyCallback {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gmaps, container, false);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapFragment fragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        googleMap.setMyLocationEnabled(true);

        final LatLng Cine1 = new LatLng(-0.206861, -78.494740);
        Marker cine1 = googleMap.addMarker(new MarkerOptions()
                .position(Cine1).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin3))
                .title("CN Cine Reina Victoria")
        );

        LatLng Cine2 = new LatLng(-0.207591, -78.483689);
        Marker cine2 = googleMap.addMarker(new MarkerOptions()
                .position(Cine2).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin3))
                .title("Ocho y Medio").snippet("Cine Clasico")
        );

        LatLng Cine3 = new LatLng(-0.198493, -78.497336);
        Marker cine3 = googleMap.addMarker(new MarkerOptions()
                .position(Cine3).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin3))
                .title("Planeta Eros Cine Club").snippet("Edificio-biblioteca de la Circasiana")
        );

        LatLng Cine4 = new LatLng(-0.175276, -78.492401);
        Marker cine4 = googleMap.addMarker(new MarkerOptions()
                .position(Cine4).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin3))
                .title("Cinemark").snippet("Plaza de las americas")
        );

        LatLng Cine5 = new LatLng(-0.177357, -78.484912);
        Marker cine5 = googleMap.addMarker(new MarkerOptions()
                .position(Cine5).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin3))
                .title("MultiCines CCI").snippet("Av. Río Amazonas N36-152")
        );

        LatLng Cine6 = new LatLng(-0.179567, -78.478904);
        Marker cine6 = googleMap.addMarker(new MarkerOptions()
                .position(Cine6).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin3))
                .title("Super Cines").snippet("Ave 6 de Diciembre")
        );

        LatLng Cine7 = new LatLng(-0.221538, -78.511412);
        Marker cine7 = googleMap.addMarker(new MarkerOptions()
                .position(Cine7).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin3))
                .title("Cine Hollywod").snippet("Guayaquil S1-76")
        );

        LatLng Cine8 = new LatLng(-0.206516, -78.425926);
        Marker cine8 = googleMap.addMarker(new MarkerOptions()
                .position(Cine8).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin3))
                .title("Multicines Scala").snippet("Psje El Valle")
        );


         LatLng Cine9 = new LatLng(-0.252350, -78.524116);
        Marker cine9 = googleMap.addMarker(new MarkerOptions()
                .position(Cine9).icon(BitmapDescriptorFactory.fromResource(R.drawable.pin3))
                .title("Multicines Recreo").snippet("Puente Lauro Guerrero")
        );

        CameraUpdate ZoomCam = CameraUpdateFactory.zoomTo(14);
        googleMap.animateCamera(ZoomCam);




        googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {

            public void onMyLocationChange(Location pos) {
                // TODO Auto-generated method stub

                // Extraigo la Lat y Lon del Listener
                double lat = pos.getLatitude();
                double lon = pos.getLongitude();
                final LatLng lati2 = new LatLng(pos.getLatitude(), pos.getLongitude());

                // Muevo la camara a mi posicion
                CameraUpdate cam = CameraUpdateFactory.newLatLng(new LatLng(
                        lat, lon));

                googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat, lon)));
                googleMap.moveCamera(cam);

                /*do {

                    PolylineOptions polyline = new PolylineOptions().add(lati2).add(new LatLng(lat, lon)).color(Color.BLUE).geodesic(true);
                    polyline.getPoints();
                    googleMap.addPolyline(polyline);
                } while (cam.equals(cam));*/


                // Notifico con un mensaje al usuario de su Lat y Lon
                Toast.makeText(GmapsClass.this.getActivity(),
                        "Lat: " + lat + "\nLon: " + lon, Toast.LENGTH_SHORT)
                        .show();


                // List<LatLng> points = null;

                // if (lat!=pos.getLatitude() && lon

            }



        });









    }
}
