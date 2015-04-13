package org.stjs.bridge.react.internal;

import org.stjs.javascript.functions.Callback0;

public abstract class ReactBaseClass<P extends Props, S extends State> {

    //BEGIN ReactComponent
    /**
     * Sets a subset of the state. Always use this to mutate
     * state. You should treat `this.state` as immutable.
     *
     * There is no guarantee that `this.state` will be immediately updated, so
     * accessing `this.state` after calling this method may return the old value.
     *
     * There is no guarantee that calls to `setState` will run synchronously,
     * as they may eventually be batched together.  You can provide an optional
     * callback that will be executed when the call to setState is actually
     * completed.
     *
     * When a function is provided to setState, it will be called at some point in
     * the future (not synchronously). It will be called with the up to date
     * component arguments (state, props, context). These values can be different
     * from this.* because your function may be called after receiveProps but before
     * shouldComponentUpdate, and this new state, props, and context will not yet be
     * assigned to this.
     *
     * @param partialState Next partial state or function to
     *        produce next partial state to be merged with current state.
     * @param callback Called after state is updated.
     */
    protected void setState(S partialState, Callback0 callback) {
        //Will be replaced on runtime
    }

    protected void setState(S partialState) {
        //Will be replaced on runtime
    }

    /**
     * Forces an update. This should only be invoked when it is known with
     * certainty that we are **not** in a DOM transaction.
     * <p/>
     * You may want to call this when you know that some deeper aspect of the
     * component's state has changed but `setState` was not called.
     * <p/>
     * This will not invoke `shouldComponentUpdate`, but it will invoke
     * `componentWillUpdate` and `componentDidUpdate`.
     *
     * @param callback Called after update is complete.
     */
    protected void forceUpdate(Callback0 callback) {
        //Will be replaced on runtime
    }
    //END ReactComponent

    //BEGIN ReactClassMixin
    /**
     * TODO: This will be deprecated because state should always keep a consistent
     * type signature and the only use case for this, is to avoid that.
     */
    protected void replaceState(S newState, Callback0 callback) {
        //Will be replaced on runtime
    }

    /**
     * Checks whether or not this composite component is mounted.
     * @return True if mounted, false otherwise.
     */
    protected boolean isMounted() {
        //Will be replaced on runtime
        return true;
    }

    /**
     * Sets a subset of the props.
     *
     * @param partialProps Subset of the next props.
     * @param callback Called after props are updated.
     * @deprecated
     */
    public native void setProps(P partialProps, Callback0 callback);

    /**
     * Replace all the props.
     *
     * @param newProps Subset of the next props.
     * @param callback Called after props are updated.
     * @deprecated
     */
    public native void replaceProps(P newProps, Callback0 callback);

    //END ReactClassMixin
}
