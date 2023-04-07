import { useState } from "react";
import PropTypes from 'prop-types';
import "./Counter.css"
import CounterButton from "./CounterButton";

export default function Counter(){
    // [0 , f]
    // first element is current state
    // second element is a function updating the state
    const [count, setCount] = useState(0)

    function incrementCounterParentFunction(by){
        setCount(count + by)
    }
    function decrementCounterParentFunction(by){
        setCount(count - by)
    }

    return (
        <div>
            <span className = "totalScore">{count}</span>
            <CounterButton by = {1} incrementMethod = {incrementCounterParentFunction} decrementMethod = {decrementCounterParentFunction}/>
            <CounterButton by = {2} incrementMethod = {incrementCounterParentFunction} decrementMethod = {decrementCounterParentFunction}/>
            <CounterButton by = {5} incrementMethod = {incrementCounterParentFunction} decrementMethod = {decrementCounterParentFunction}/>
            <button className = "resetButton" onClick = {() => setCount(0)}>Reset</button>
        </div>
        
    )
}

Counter.propTypes = {
    by: PropTypes.number
}
Counter.defaultProps = {
    by: 1
}