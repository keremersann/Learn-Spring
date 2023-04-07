const person = {
    name: "Kerem",
    address: {
        line1: "Baker Street",
        city: "London",
        country: "UK"
    },
    profiles: ["twitter", "instagram", "linkedin"],
    printProfile: () => {
        person.profiles.map(
            profile => console.log(profile)
        )
    }
}

export default function LearningJavaScriptComponent(){
    return (
        <div>
            <div>{person.name}</div>
            <div>{person.address.city}</div>
            <div>{person.profiles[0]}</div>
            <div>{person.printProfile()}</div> 
        </div>
    )
}