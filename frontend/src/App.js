import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import { Routes, Route} from 'react-router-dom';
import Registration from './page/Registration';
import Login from './page/Login';
import Student from './page/Student';
import './App.css'; 

function App() {
  return (
    <div className="App">
      <div className='wrapper'>
      <Routes>
        <Route path="/reg" element={<Registration/>}/>
        <Route path="/" element={<Login/>}/>
        <Route path="/student" element={<Student/>}/>
      </Routes>
      </div>
    </div>
  );
}

export default App;