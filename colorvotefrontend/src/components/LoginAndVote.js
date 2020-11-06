import React, { Component } from 'react'
import Vote from './Vote';
export default class LoginAndVote extends Component {


    constructor() {
        super();
        this.state = {
            userName : ""
        }
        this.submitInput = this.submitInput.bind(this);
    }

    submitInput(event) {

        event.preventDefault();

        let typedName = document.getElementById("user_name").value;
            console.log(typedName);


            this.checkForDupeUsers(typedName);

    }

    checkForDupeUsers(usserToCheck) {
        const data = { name: usserToCheck };

       let jsonData = JSON.stringify(data);

       console.log("Json Data is: ");
       console.log(jsonData);

fetch('http://localhost:8080/colorvoteapi/v1/user/dupes', {
  method: 'POST', // or 'PUT'
  headers: {
    'Content-Type': 'application/json',
  },
  body: jsonData,
})
.then(response => response.json())
.then(data => {
  console.log('Success:', data);
  if(data.length > 0)
  {
    console.log("That user already exists, type another");
    alert("That user already exists. Please type another.");
  }
  else
  {
      if(usserToCheck)
            {
                this.setState({
                    userName: usserToCheck,
         
                  });
            }
  }
})
.catch((error) => {
  console.error('Error:', error);
  

});


    }


    render() {

        if(this.state.userName)
        {
            return(<div>


                <Vote userName = {this.state.userName}/>


            </div>)
        }
        else{
        return (
            <div>
                  <h2>Enter A Username to Vote With </h2>

                    <form onSubmit={this.submitInput}>
                    <input type="text" id="user_name" name="uname" />
                    <br/> <br/>
                    <input id="submitButton" type="submit" value="Submit"/>
                </form> 
                
            </div>
        )
        }
    }
}
