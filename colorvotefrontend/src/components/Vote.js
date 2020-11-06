import React, { Component } from 'react'
import VoteResults from './VoteResults'
const YELLOW_VOTED_COLOR = "yellow";
const BLUE_VOTED_COLOR = "blue";
const RED_VOTED_COLOR = "red";

export default class Vote extends Component {

    constructor() {
        super();
        this.state = {
            userVoted : false
        }
        
    }


    yellowClicked(){

        console.log("yellow clicked");
       // console.log(this.props.userName);

        this.postUser(YELLOW_VOTED_COLOR);

    }
    blueClicked(){
        console.log("blue clicked");

        this.postUser(BLUE_VOTED_COLOR);
    }
    redClicked(){
      
        console.log("red clicked");
        this.postUser(RED_VOTED_COLOR);
    }

    postUser(votedColor) {

        const data = { name: this.props.userName };

       let jsonData = JSON.stringify(data);

       console.log("Json Data is: ");
       console.log(jsonData);

fetch('http://localhost:8080/colorvoteapi/v1/user/' + votedColor, {
  method: 'POST', // or 'PUT'
  headers: {
    'Content-Type': 'application/json',
  },
  body: jsonData,
})
.then(response => response.json())
.then(data => {
  console.log('Success:', data);
  {
    this.setState({
        userVoted: true,

      });
}
})
.catch((error) => {
  console.error('Error:', error);
  

});


    }

    render() {

        if(this.state.userVoted)
        {
            return(
                <div>
                    <VoteResults/>
                </div>
            )
        }
        else
        {
        return (
            <div>
                <h2>Choose which primary color you like the best:</h2>

                <button style = {{backgroundColor : "yellow"}} onClick={() => this.yellowClicked()}>yellow</button> 
                <br/><br/>
                <button style = {{backgroundColor : "blue"}} onClick={() => this.blueClicked()}>blue</button> 
                <br/><br/>
                <button style = {{backgroundColor : "red"}} onClick={() => this.redClicked()}>red</button>           
                <br/><br/>    
            </div>
        )
        }
    }
}
