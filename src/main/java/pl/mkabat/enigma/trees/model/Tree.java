package pl.mkabat.enigma.trees.model;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public abstract class Tree {

    protected String name;

    protected String trunk;

    protected Set<String> branches;

    protected Set<String> leafes;

    public void grow() {
        log.info("tree {} is growing", name);
    }
}
