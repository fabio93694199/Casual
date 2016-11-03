package com.example.ti.novocasual;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Apontamentos extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private DatabaseReference databaseReference,banco,banco1;
    private ArrayList<Usuario> lstUsuario = new ArrayList<Usuario>();
    private ArrayList minhaListaTest;
    //private ArrayList<Usuario> lstUsuario = new ArrayList<>();
    //private ArrayList<Double> lstUsuario = new ArrayList<>();
    private String test1;
    private String conteudo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //lstUsuario = ;




        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
/*
                LatLng apontamento1 = new LatLng(-30.1412498, -51.1298999);
                LatLng apontamento2 = new LatLng(-30.1402498, -51.1288999);

                mMap.addMarker(new MarkerOptions().position(apontamento1).title("Apontado no(a) IFRS").snippet("Campus Retinga\nPorto Alegre\nRio Grande do Sul"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(apontamento1, 15));
*/
        mMap.getUiSettings().setMapToolbarEnabled(false);
        new Localizar().execute();
        mMap.setMyLocationEnabled(true);

    }

    //////////test//////////////

    protected void testDeLista(ArrayList<Usuario> us){
        lstUsuario = us;
    }
    ///////////////////////////

    protected class Localizar implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private GoogleApiClient m_api;

        public Localizar(){
            super();
        }

        protected void execute(){
            m_api = new GoogleApiClient.Builder(getActivity())
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
            m_api.connect();
        }

        @Override
        public void onConnected(Bundle bundle){

            databaseReference = FirebaseDatabase.getInstance().getReference();
            banco = databaseReference.child("brasil").child("RioGrandeDoSul");

            banco.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Usuario use = dataSnapshot.getValue(Usuario.class);
                    mMap.addMarker(new MarkerOptions().position(new LatLng(0.0,0.0)).title("Eu").snippet(use.getEmail()));
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            /*
            LatLng latLng = location();

            mMap.addMarker(new MarkerOptions().position(latLng).title("Eu").snippet("29 anos"));
            mMap.animateCamera(cameraPosition(latLng,15,0,0));
            m_api.disconnect();
            */
            LatLng latLng = location();

            //mMap.addMarker(new MarkerOptions().position(latLng).title("Eu").snippet(lstUsuario.get(1).getEmail().toString()));
            //mMap.addMarker(new MarkerOptions().position(latLng).title("Eu").snippet(Integer.toString(lstUsuario.size())));


//            mMap.addMarker(new MarkerOptions().position(latLng).title("Eu").snippet("test"));


            //for (int i= 0; i<lstUsuario.size();i++) {
            //    mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(lstUsuario.get(i).getLat()),Double.parseDouble(lstUsuario.get(i).getLng()))).title(lstUsuario.get(i).getNome().toString()).snippet(lstUsuario.get(i).getEmail().toString()));
            //    //mMap.animateCamera(cameraPosition(latLng, 15, 0, 0));
            //}
            mMap.animateCamera(cameraPosition(latLng, 15, 0, 0));
            m_api.disconnect();

            //String test2= String.valueOf(test1);
            //Toast.makeText(getContext(),test2,Toast.LENGTH_LONG);
        }

        @Override
        public void onConnectionSuspended(int i){

        }

        @Override
        public void onConnectionFailed(ConnectionResult connectionResult){

        }

        public CameraUpdate cameraPosition(LatLng latLng, float zoom, float tilt, float bearing){
            CameraPosition.Builder builder = new CameraPosition.Builder();

            CameraPosition position = builder.target(latLng)
                    .zoom(zoom)
                    .tilt(tilt)
                    .bearing(bearing)
                    .build();

            return CameraUpdateFactory.newCameraPosition(position);
        }

        public LatLng location(){
            Location loc = LocationServices.FusedLocationApi.getLastLocation(m_api);

            return new LatLng(loc.getLatitude(),loc.getLongitude());
        }
        //////////////////////////////////////////////////////////////////////////////

    } // Fim da Classe Localizar
    /////////////////////////////////////////////////////////////////////////////////
} // Fim da Classe Apontamento
