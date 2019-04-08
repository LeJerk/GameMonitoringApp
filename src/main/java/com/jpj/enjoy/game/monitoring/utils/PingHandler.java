package com.jpj.enjoy.game.monitoring.utils.pipelinr;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

class PingHandler implements Command.Handler<Ping, Voidy> {

    @Override
    public Voidy handle(Ping command) {
        String host = command.host;
        // ... ping logic here ...
        return new Voidy();
    }
}

