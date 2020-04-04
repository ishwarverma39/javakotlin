package com.livtech.demo.nodes;

public class ThreadedBTNode extends BTNode {
    private boolean isRightThreaded = false;

    public boolean isRightThreaded() {
        return isRightThreaded;
    }

    public void setRightThreaded(boolean rightThreaded) {
        isRightThreaded = rightThreaded;
    }
}
