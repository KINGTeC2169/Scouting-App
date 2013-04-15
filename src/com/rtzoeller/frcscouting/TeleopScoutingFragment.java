package com.rtzoeller.frcscouting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class TeleopScoutingFragment extends ScoutingFragment {

	public static String ARG_SECTION_NUMBER = "section_number";

	private LinearLayout teleop = null;
	
	public TeleopScoutingFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		setRetainInstance(true);
		final LinearLayout teleop = (LinearLayout)inflater.inflate(R.layout.fragment_teleop_scouting, container, false);
		this.teleop = teleop;

		((Button)teleop.findViewById(R.id.lowgoaldec)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				lowgoal = decrement(lowgoal);
				((TextView)teleop.findViewById(R.id.lowgoalcounter)).setText(Integer.toString(lowgoal));
			}
		});

		((Button)teleop.findViewById(R.id.lowgoalinc)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				lowgoal = increment(lowgoal);
				((TextView)teleop.findViewById(R.id.lowgoalcounter)).setText(Integer.toString(lowgoal));
			}
		});

		((Button)teleop.findViewById(R.id.medgoaldec)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mediumgoal = decrement(mediumgoal);
				((TextView)teleop.findViewById(R.id.medgoalcounter)).setText(Integer.toString(mediumgoal));
			}
		});

		((Button)teleop.findViewById(R.id.medgoalinc)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mediumgoal = increment(mediumgoal);
				((TextView)teleop.findViewById(R.id.medgoalcounter)).setText(Integer.toString(mediumgoal));
			}
		});

		((Button)teleop.findViewById(R.id.highgoaldec)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				highgoal = decrement(highgoal);
				((TextView)teleop.findViewById(R.id.highgoalcounter)).setText(Integer.toString(highgoal));
			}
		});

		((Button)teleop.findViewById(R.id.highgoalinc)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				highgoal = increment(highgoal);
				((TextView)teleop.findViewById(R.id.highgoalcounter)).setText(Integer.toString(highgoal));
			}
		});

		((Button)teleop.findViewById(R.id.pyramidgoaldec)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				pyramidgoal = decrement(pyramidgoal);
				((TextView)teleop.findViewById(R.id.pyramidgoalcounter)).setText(Integer.toString(pyramidgoal));
			}
		});

		((Button)teleop.findViewById(R.id.pyramidgoalinc)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				pyramidgoal = increment(pyramidgoal);
				((TextView)teleop.findViewById(R.id.pyramidgoalcounter)).setText(Integer.toString(pyramidgoal));
			}
		});

		return teleop;
	}
	
	@Override
	public String[] serialize() {
		// Return a string array with our tele-op data
		String[] goals = super.serialize();
				
		String[] s = {goals[0], goals[1], goals[2], goals[3], // Grab our goal data
				Integer.toString(((Spinner)teleop.findViewById(R.id.pyramidspinner)).getSelectedItemPosition()),
				Integer.toString(((Spinner)teleop.findViewById(R.id.foulspinner)).getSelectedItemPosition()),
				Integer.toString((((CheckBox)teleop.findViewById(R.id.pushedothers)).isChecked() ? 1 : 0)),
				Integer.toString((((CheckBox)teleop.findViewById(R.id.waspushed)).isChecked() ? 1 : 0)),
				Integer.toString((((CheckBox)teleop.findViewById(R.id.deadsticked)).isChecked() ? 1 : 0)),
				((EditText)teleop.findViewById(R.id.comments)).getText().toString()};
		return s;
	}
}