import { useState, useEffect } from "react";
import { Button } from "react-bootstrap";
import { NavLink } from "react-router-dom";
import Select from "react-select";
import NavbarModerator from "./component/NavbarModerator";
import card_img from "../img/cool-card.png";
import './registr.css';
import '../css/profile.css'; 

function VacanciesEdit() {
    const [searchTerm, setSearchTerm] = useState("");
    const [selectedOption, setSelectedOption] = useState(null);
    const [vac, setVac] = useState('');
    const options = [
        { value: "option1", label: "Опция 1" },
        { value: "option2", label: "Опция 2" },
        { value: "option3", label: "Опция 3" }
      ];

    const handleSelectChange = (selectedOption) => {
        setSelectedOption(selectedOption);
    };

    const handleSearchChange = (event) => {
        setSearchTerm(event.target.value);
    };

    useEffect(() => {
        fetch(`http://localhost:8080/api/announcement`, {
          method: 'GET'
        })
          .then(response => {
            if (!response.ok) {
              throw new Error('Network response was not ok');
            }
            return response.json();
          })
          .then(res => setVac(res))
          .catch(error => console.error('Error fetching films:', error));
      }, [setVac]);

    return (
        <div className="container-fluid">
            <div className="row g-4">
                <div className="col-lg-3 px-0">
                    <NavbarModerator/>
                </div>
                <div className="col-lg-9">
                    <div className="row">
                        <div className="col-lg-4"></div>
                    </div>
                    <div className="container px-4 py-5">
                    <div className="row g-3 pb-5">
                        <div className="col-lg-4">
                            <label htmlFor="searchInput" className="d-none">Поиск по названию:</label>
                            <input className="form-control"
                            type="text"
                            id="searchInput"
                            value={searchTerm}
                            onChange={handleSearchChange}
                            placeholder="Поиск по названию"
                            />
                        </div>
                        <div className="col-lg-8">
                            <Select
                                id="selectInput"
                                value={selectedOption}
                                onChange={handleSelectChange}
                                options={options}
                                isMulti
                                placeholder="Выберите теги"
                            />
                        </div>
                        <div className="col-12">
                           <Button className="w-100"><NavLink to='/vacancis/create'>Создать вакансию</NavLink></Button>
                        </div>
                        </div>
                        <div className="row row-cols-xl-4 row-cols-lg-3 row-cols-md-2 g-4">
                            {Array.isArray(vac) ? vac.map((f, index) => (
                            <div className="col" key={index}>
                                <div className="card">
                                    <img src={card_img} className="card-img-top" alt="" />
                                    <div className="card-body">
                                        <h5 className="card-title">{f.header}</h5>
                                        <p className="card-text">{f.needs}</p>
                                        <div className="d-flex gap-2 flex-wrap mb-3">
                                            <p className="m-0 badge">Аналитика</p>
                                            <p className="m-0 badge">Java</p>
                                            <p className="m-0 badge">React</p>
                                            <p className="m-0 badge">Docker</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            )) : null}
                        </div>
                        <div className="row g-4">
                            <div className="col-lg-4">
                                <div className="card">
                                    <img src={card_img} className="card-img-top" alt="" />
                                    <div className="card-body">
                                        <h5 className="card-title">Системный аналитик</h5>
                                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                        <div className="d-flex gap-2 flex-wrap mb-3">
                                            <p className="m-0 badge">Аналитика</p>
                                            <p className="m-0 badge">Java</p>
                                            <p className="m-0 badge">React</p>
                                            <p className="m-0 badge">Docker</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default VacanciesEdit;


