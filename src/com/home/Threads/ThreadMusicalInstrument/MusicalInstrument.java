package com.home.Threads.ThreadMusicalInstrument;

import java.util.Date;

public interface MusicalInstrument extends Runnable
{
    Date startPlaying();

    Date stopPlaying();
}
