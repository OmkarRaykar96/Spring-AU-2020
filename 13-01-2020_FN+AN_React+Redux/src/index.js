import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux'
import './index.css';
import Pollution from './Pollution/Pollution';
import thunk from 'redux-thunk';
import { createStore, applyMiddleware } from 'redux';
import * as serviceWorker from './serviceWorker';
import { reduce } from './reducers/reducers';

export const storage = createStore(reduce, applyMiddleware(thunk));

ReactDOM.render(<div> 
    <Provider store = {storage}>
    <Pollution/>
    </Provider>
    </div>, document.getElementById('root'));

serviceWorker.unregister();