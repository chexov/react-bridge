package org.stjs.bridge.react.internal;

import org.stjs.javascript.Map;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.functions.Callback0;

abstract public class ReactClassInterface<P, S> extends ReactClassStatefulInterface<P,S> implements ReactClassLifecycleInterface<P,S> {

	/**
	 * This concept is not documented yet
	 */
	protected Object context;

	/**
	 * Definition of context types for this component.
	 */
	@Deprecated
	public Map<String, String> contextTypes;

	/**
	 * Definition of context types this component sets for its children.
	 */
	@Deprecated
	public Map<String, String> childContextTypes;

	/**
	 * Context is an object shared between all Components
	 */
	public native Context getChildContext();

	@Override
	public native void componentWillMount();

	@Override
	public native void componentDidMount(Element element);

	@Override
	public native void componentWillReceiveProps(P nextProps);

	@Override
	public native boolean shouldComponentUpdate(P nextProps, S nextState, Context nextContext);

	@Override
	public native boolean componentWillUpdate(P nextProps, S nextState, Context nextContext, ReactReconcileTransaction transaction);

	@Override
	public native void componentDidUpdate(P prevProps, S prevState, Context prevContext, Element rootNode);

	@Override
	public native void componentWillUnmount();

	/**
	 * Updates the component's currently mounted DOM representation.
	 *
	 * By default, this implements React's rendering and reconciliation algorithm. Sophisticated clients may wish to
	 * override this.
	 *
	 */
	public native void updateComponent(ReactReconcileTransaction transaction);

	/**
	 * Uses props from `this.props` and state from `this.state` to render the structure of the component.
	 *
	 * No guarantees are made about when or how often this method is invoked, so it must not have side effects.
	 *
	 * render: function() { var name = this.props.name; return <div>Hello, {name}!</div>; }
	 */
	public abstract ReactElement<?> render();

	// BEGIN ReactComponent

	/**
	 * Forces an update. This should only be invoked when it is known with certainty that we are **not** in a DOM
	 * transaction.
	 * <p/>
	 * You may want to call this when you know that some deeper aspect of the component's state has changed but
	 * `setState` was not called.
	 * <p/>
	 * This will not invoke `shouldComponentUpdate`, but it will invoke `componentWillUpdate` and `componentDidUpdate`.
	 *
	 * @param callback
	 *            Called after update is complete.
	 */
	protected void forceUpdate(Callback0 callback) {
		// Will be replaced on runtime
	}

	/**
	 * If this component has been mounted into the DOM, this returns the corresponding native browser DOM element. This
	 * method is useful for reading values out of the DOM, such as form field values and performing DOM measurements.
	 * When render returns null or false, this.getDOMNode() returns null.
	 * 
	 * Note: getDOMNode is deprecated and has been replaced with ReactDOM.findDOMNode(). This method is not available on
	 * ES6 class components that extend React.Component. It may be removed entirely in a future version of React.
	 * 
	 * @return
	 */
	@Deprecated
	public native Element getDOMNode();
	// END ReactComponent
}
