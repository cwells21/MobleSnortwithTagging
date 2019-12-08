//This isn't final, I will be working on this further
//It does not work properly yet

package com.example.mobilethreathunting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mobilethreathunting.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataActivityUnfinished extends AppCompatActivity{

    String theTag = "MainActivity";
    FirebaseDatabase theDatabase = FirebaseDatabase.getInstance();
    DatabaseReference theReference = theDatabase.getReference("message");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void writeNewMac(String MACaddress){
        //Write a new MAC Address to the database
        theReference.child("MAC_Address").setValue(MACaddress);
    }

    public void writeNewGPS(String MACaddress, String theLat, String theLong ){
        //New Entry for the Location

        theReference.child("MAC_Address").child(MACaddress).child("GPS_Location").child("Longitude").setValue(theLong);
        theReference.child("MAC_Address").child(MACaddress).child("GPS_Location").child("Latitude").setValue(theLat);
    }

    public void addLocation(String MACaddress, String Location){
        theReference.child("MAC_Address").child(MACaddress).child("Where_they_Went").setValue(Location);
    }

    public void addProtocols(String MACaddress, String Protocol){
        theReference.child("MAC_Address").child(MACaddress).child("Where_they_Went").setValue(Protocol);
    }

    public void addViolations(String MACaddress, String Violation){
        theReference.child("MAC_Address").child(MACaddress).child("Where_they_Went").setValue(Violation);
    }

    public void readMethod(){
        //Reading something from the database
        theReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(theTag, "The value read is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(theTag, "Unable to read the value.", error.toException());
            }
        });
    }
}
