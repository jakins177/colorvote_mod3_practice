import React, { Component } from 'react'

export default class VoteResults extends Component {


    constructor() {
        super();
        this.state = {
            blueVotes : 0,
            redVotes : 0,
            yellowVotes: 0
        }
        
    }

    fetchYellowCount() {
        
        fetch( `http://localhost:8080/colorvoteapi/v1/user/yellow/count`)
     // fetch(`https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=${this.state.searchedLAT},${this.state.searchedLNG}&radius=5000&keyword=covid-19%20testing&key=${GOOGLE_MAPS_API_KEY}`, {)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
         
        this.setState({
            yellowVotes: data
        })
  
      })

    }

    fetchBlueCount() {
        
        fetch( `http://localhost:8080/colorvoteapi/v1/user/blue/count`)
     // fetch(`https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=${this.state.searchedLAT},${this.state.searchedLNG}&radius=5000&keyword=covid-19%20testing&key=${GOOGLE_MAPS_API_KEY}`, {)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
         
        this.setState({
            blueVotes: data
        })
  
      })
    }

    fetchRedCount() {

        
        fetch( `http://localhost:8080/colorvoteapi/v1/user/red/count`)
     // fetch(`https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=${this.state.searchedLAT},${this.state.searchedLNG}&radius=5000&keyword=covid-19%20testing&key=${GOOGLE_MAPS_API_KEY}`, {)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
         
        this.setState({
            redVotes: data
        })
  
      })
        
    }
   
    componentDidMount () {
        this.fetchBlueCount();
        this.fetchRedCount();
        this.fetchYellowCount();
       
    }

    render() {
        return (
            <div style={{textAlign:"center", width:"100%"}}>
                <h2>Thank you for voting!</h2>
        
                <div id = "inner-div" style={{backgroundColor: "yellow", width:"25%"}}>
                <h2>{this.state.yellowVotes}</h2>
                </div>
               <br/>
                <div id = "inner-div" style={{backgroundColor: "blue", width:"25%"}}>
                <h2>{this.state.blueVotes}</h2>
                </div>
                <br/>
                <div id = "inner-div" style={{backgroundColor: "red", width:"25%"}}>
                <h2>{this.state.redVotes}</h2>
                </div>
                
            </div>
        )
    }
}
