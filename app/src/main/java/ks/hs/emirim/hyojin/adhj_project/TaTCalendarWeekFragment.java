package ks.hs.emirim.hyojin.adhj_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ks.hs.emirim.hyojin.adhj_project.widget.TaTCalendarWeekItemView;
import ks.hs.emirim.hyojin.adhj_project.widget.TaTCalendarWeekView;

import java.util.Calendar;

/**
 * Created by kitte on 2016-12-29.
 */

public class TaTCalendarWeekFragment extends Fragment {
    private int position;
    private long timeByMillis;
    private ks.hs.emirim.hyojin.adhj_project.TaTCalendarWeekFragment.OnFragmentListener onFragmentListener;
    private View mRootView;
    private TaTCalendarWeekView calendarView;

    public void setOnFragmentListener(ks.hs.emirim.hyojin.adhj_project.TaTCalendarWeekFragment.OnFragmentListener onFragmentListener) {
        this.onFragmentListener = onFragmentListener;
    }

    public interface OnFragmentListener{
        public void onFragmentListener(View view);
    }

    public static ks.hs.emirim.hyojin.adhj_project.TaTCalendarWeekFragment newInstance(int position) {
        ks.hs.emirim.hyojin.adhj_project.TaTCalendarWeekFragment frg = new ks.hs.emirim.hyojin.adhj_project.TaTCalendarWeekFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        frg.setArguments(bundle);
        return frg;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("poisition");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_tat_calendar_week, null);
        calendarView = (TaTCalendarWeekView) mRootView.findViewById(R.id.calendarweekview);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeByMillis);

        for (int i = 0; i < 14; i++) {
            TaTCalendarWeekItemView child = new TaTCalendarWeekItemView(getActivity().getApplicationContext());
            child.setDate(calendar.getTimeInMillis());
            if (i < 7) {
                child.setDayOfWeek(i);
            } else {
                calendar.add(Calendar.DATE, 1);
            }
            calendarView.addView(child);
        }
        return mRootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser && onFragmentListener != null && mRootView != null) {
            onFragmentListener.onFragmentListener(mRootView);
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint()) {

            mRootView.post(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    onFragmentListener.onFragmentListener(mRootView);
                }
            });

        }
    }

    public void setTimeByMillis(long timeByMillis) {
        this.timeByMillis = timeByMillis;
    }
}
