import React from 'react';
import { BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Login from './Login'; // Import your Login component
import Registration from './Register'; // Import your Registration component

function App() {
    return (
        <Router>
            <Switch>
                <Route exact path="/login" component={Login} />
                <Route exact path="/register" component={Registration} />
            </Switch>
        </Router>
    );
}

export default App;
