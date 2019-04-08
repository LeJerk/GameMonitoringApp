package com.jpj.enjoy.game.monitoring.utils.pipelinr;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

class RemotePingHandler implements Command.Handler<Ping, Voidy> {

    @Override
    public Voidy handle(Ping ping) {
        return null;
    }

    @Override
    public boolean matches(Ping command) {
        return !command.host.equals("localhost");
    }
}
