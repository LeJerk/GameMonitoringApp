package com.jpj.enjoy.game.monitoring.utils.pipelinr;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.PipelineStep;

// step two (wraps a command handling in a transaction)
class WrapInATransaction implements PipelineStep {

    @Override
    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
        // start tx
        R response = next.invoke();
        // end tx
        return response;
    }
}
