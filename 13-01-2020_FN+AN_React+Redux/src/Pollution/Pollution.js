import React, { Component } from 'react';
import './Pollution.css';
import { connect } from 'react-redux';

import { fetchPollution,search } from './PollutionFunction'

class Pollution extends Component  {
   search = (event) => {
      var regex = new RegExp(event.target.value);
      this.props.dispatch(search(regex));      
   }

   constructor(props){
    super(props);
    this.state = {
        pollution : [],
        filter : [],
        error : null,
    };
}

    componentDidMount(){
        this.props.dispatch(fetchPollution());
      }

    render() {
      const { error, pollution } = this.props;
      if (error) {
        return <div>Error! {error.message}</div>;
      }

  return (
    
    <div className="Pollution">
    

        <input type="text" id="Search" class="textbox" placeholder="Search" onKeyUp={this.search}></input>      

        <div className="Pollution">
        <table>
          <tbody>
            <tr>
              <td><b>ID</b></td>
              <td><b>Country</b></td>
              <td><b>State</b></td>
              <td><b>City</b></td>
              <td><b>Station</b> </td>
              <td><b>Update</b></td>
              <td><b>Pol_ID</b></td>
              <td><b>Min</b></td>
              <td><b>Max</b></td>
              <td><b>Avg</b></td>
              <td><b>Unit</b></td>
            </tr>
          {pollution.map((pollutant) => (
            <tr key={pollutant.id}>
              <td>{pollutant.id}</td>
              <td>{pollutant.country}</td>
              <td>{pollutant.state}</td>
              <td>{pollutant.city}</td>
              <td>{pollutant.station}</td>
              <td>{pollutant.last_update}</td>
              <td>{pollutant.pollutant_id}</td>
              <td>{pollutant.pollutant_min}</td>
              <td>{pollutant.pollutant_max}</td>
              <td>{pollutant.pollutant_avg}</td>
              <td>{pollutant.pollutant_unit}</td>
            </tr>
          ))}
          </tbody>
        </table>
      </div>

      </div>
  );
}
}   

var mapStateToProps = (state) => {
  return {
      pollution: state.pollution
  };
}

export default connect(mapStateToProps)(Pollution);
