
import Login from 'Login';
import { Route, BrowserRouter as Router } from "react-router-dom";
import {render} from "react-dom";




function App() {

    return(
        <Router>
            <Route exact path="" component={Login} />
        </Router>

    );

}


export default App;
