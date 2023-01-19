schedule meeting {
  assign name "Meeting to discuss why meetings aren't effective"
  starts at 14..30
  ends at 15..30  
  on date 15 March 2020
  participants include "Sara" and "Jake" and "Mani"
}

//This is what is really going on.
//The schedule.meeting function accepts a block of code which is applied to an instance of Meeting.
schedule.meeting {
  this.assign.name("Meeting to discuss why meetings aren't effective")
  this.starts.at(14..30)
  this.ends.at(15..30)
  this.on.date(15).March(2020)
  this.participants.include("Sara").and("Jake").and("Mani")
}