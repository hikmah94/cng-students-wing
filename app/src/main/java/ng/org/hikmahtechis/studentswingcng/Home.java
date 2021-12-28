package ng.org.hikmahtechis.studentswingcng;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import ng.org.hikmahtechis.studentswingcng.R;


public class Home extends Fragment {
    View rootView;
    public static GridView gridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        {
            // Inflate the layout for this fragment
            rootView = inflater.inflate(R.layout.fragment_home, null);
            final ArrayList<Word> words = new ArrayList<Word>();
            //words.add("one");
            words.add(new Word("LEADERSHIP", R.drawable.leadership));
            words.add(new Word("ICAADA", R.drawable.icaada));
            words.add(new Word("GALLERY", R.drawable.gallery));
            words.add(new Word("CNG TV", R.drawable.tv));
            words.add(new Word("EVENTS", R.drawable.event));
            words.add(new Word("NOTIFICATIONS", R.drawable.notification));
            words.add(new Word("E-Session", R.drawable.coe_courses));
            words.add(new Word("E-Learning", R.drawable.lms));
            words.add(new Word("CGPA CALCULATOR", R.drawable.coe_cgpa));
            words.add(new Word("JOURNAL", R.drawable.journal));
            words.add(new Word("FORUMS", R.drawable.forum));
            words.add(new Word("NEWS", R.drawable.news));
            words.add(new Word("UTILITIES", R.drawable.coe_home));
            words.add(new Word("FEEDBACKS", R.drawable.coe_union));
            WordAdapter adapter = new WordAdapter(getActivity(), words);


            GridView listView = (GridView) rootView.findViewById(R.id.gridview);

            listView.setAdapter(adapter);

            // Set a click listener to play the audio when the list item is clicked on
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    // Release the media player if it currently exists because we are about to
                    // play a different sound file
                    // Get the {@link Word} object at the given position the user clicked on
                    Word word = words.get(position);
                    {
                        if (position == 0) {
                            Intent i = new Intent(getActivity(), Leadership.class);
                            startActivity(i);
                        } else if (position == 1) {
                            Intent i = new Intent(getActivity(), Icaada.class);
                            startActivity(i);
                        } else if (position == 2) {
                            Intent i = new Intent(getActivity(), Gallery.class);
                            startActivity(i);
                        } else if (position == 3) {
                            Intent i = new Intent(getActivity(), CngTv.class);
                            startActivity(i);
                        } else if (position == 4) {
                            Intent i = new Intent(getActivity(), Event.class);
                            startActivity(i);
                        } else if (position == 5) {
                            Intent i = new Intent(getActivity(), Notification.class);
                            startActivity(i);
                        } else if (position == 6) {
                            Intent i = new Intent(getActivity(), Educations.class);
                            startActivity(i);
                        }else if (position == 7) {
                            Intent i = new Intent(getActivity(), Lmss.class);
                            startActivity(i);
                        }else if (position == 8) {
                            Intent i = new Intent(getActivity(), Calculator.class);
                            startActivity(i);
                        }else if (position == 9) {
                            Intent i = new Intent(getActivity(), Journal.class);
                            startActivity(i);
                        } else if (position == 10) {
                            Intent i = new Intent(getActivity(), Forums.class);
                            startActivity(i);
                        } else if (position == 11) {
                            Intent i = new Intent(getActivity(), News.class);
                            startActivity(i);
                        } else if (position == 12) {
                            Intent i = new Intent(getActivity(), Utility.class);
                            startActivity(i);
                        } else if (position == 13) {
                            Intent i = new Intent(getActivity(), FeedBack.class);
                            startActivity(i);
                        }

                    }
                }

            });

            return rootView;
        }
    }
}
