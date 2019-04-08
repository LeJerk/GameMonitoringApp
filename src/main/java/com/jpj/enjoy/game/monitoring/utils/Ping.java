package com.jpj.enjoy.game.monitoring.utils.pipelinr;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

class Ping implements Command<Voidy> {

    public final String host;

    public Ping(String host) {
        this.host = host;
    }
}
