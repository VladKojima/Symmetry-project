import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import { Routes, Route} from 'react-router-dom';
import Registration from './page/Registration';
import Login from './page/Login';
import Student from './page/Student';
import Students from './page/Students';
import StudentEdit from './page/StudentEdit';
import Vacancies from './page/Vacancies';
import Moderator from './page/Moderator';
import ModeratorEdit from './page/ModeratorEdit';
import VacanciesEdit from './page/VacanciesEdit';
import VacanciesCreate from './page/VacanciesCreate';
import News from './page/News';
import NewsCreate from './page/NewsCreate';
import StudentCreate from './page/StudentCreate';
import NewsStud from './page/NewsStud';
import './App.css'; 

function App() {
  return (
      <div className="App">
        <div className='wrapper'>
        <Routes>
          <Route path="/reg" element={<Registration/>}/>
          <Route path="/" element={<Login/>}/>
          <Route path="/student" element={<Student/>}/>
          <Route path="/student/edit" element={<StudentEdit/>}/>
          <Route path='/vacancies' element={<Vacancies/>}/>
          <Route path='/moderator' element={<Moderator/>}/>
          <Route path='/moderator/edit' element={<ModeratorEdit/>}/>
          <Route path="/students" element={<Students/>}/>
          <Route path="/vacancis" element={<VacanciesEdit/>}/>
          <Route path='/vacancis/create' element={<VacanciesCreate/>}/>
          <Route path='/news' element={<News/>}/>
          <Route path='/newss' element={<NewsStud/>}/>
          <Route path='/news/create' element={<NewsCreate/>}/>
          <Route path='/students/create' element={<StudentCreate/>}/>
        </Routes>
        </div>
      </div>
  );
}

export default App;