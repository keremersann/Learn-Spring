
export default function CounterButton({by, incrementMethod, decrementMethod}){

     function incrementCounterButtonFunction(){
         incrementMethod(by)
     }

     function decrementCounterButtonFunction(){
         decrementMethod(by)
     }

    return (
            <div>
                <button className = "counterButton" onClick = {incrementCounterButtonFunction}>+{by}</button>
                <button className = "counterButton" onClick= {decrementCounterButtonFunction}>-{by}</button>
            </div>
    )
}