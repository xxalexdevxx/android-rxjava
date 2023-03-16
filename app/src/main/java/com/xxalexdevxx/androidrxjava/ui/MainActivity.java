package com.xxalexdevxx.androidrxjava.ui;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.xxalexdevxx.androidrxjava.R;
import com.xxalexdevxx.androidrxjava.data.model.Podcast;
import com.xxalexdevxx.androidrxjava.data.repositories.PodcastRepository;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private PodcastRepository podcastRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize podcastrespository
        podcastRepository = new PodcastRepository();

        // fetch podcasts from api
         searchPodcasts();

    }

    private void searchPodcasts() {
        compositeDisposable.add (
                podcastRepository.searchPodcasts()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe (
                                podcasts -> {
                                    // display podcasts in recyclerview
                                    for (Podcast podcast : podcasts) {
                                        Log.d("Response", podcast.getPodcastTitle());
                                    }


                                },
                                throwable -> {
                                    // handle error
                                }
                        )
        );
    }
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
