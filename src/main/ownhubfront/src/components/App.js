<<<<<<< HEAD

import Login from 'Login';
import { Route, BrowserRouter as Router } from "react-router-dom";
import {render} from "react-dom";

=======
import React, {useEffect, useState} from "react";
import axios from "axios";
import Login from 'Login';
>>>>>>> refs/remotes/origin/master



function App() {

    return(
        <Router>
            <Route exact path="" component={Login} />
        </Router>

    );

}


export default App;
