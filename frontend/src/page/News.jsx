import { useState, useEffect } from "react";
import { Button } from "react-bootstrap";
import { NavLink } from "react-router-dom";
import Select from "react-select";
import NavbarModerator from "./component/NavbarModerator";
import card_img from "../img/cool-card.png";
import './registr.css';
import '../css/profile.css'; 

function News() {
    const [searchTerm, setSearchTerm] = useState("");
    const [selectedOption, setSelectedOption] = useState(null);
    const [vac, setVac] = useState('');
    const [filteredVac, setFilteredVac] = useState('');
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
        fetch(`http://localhost:8080/api/new`, {
            method: 'GET',
            credentials: 'include'
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(res => {
            setVac(res);
            setFilteredVac(res);
        })
        .catch(error => console.error('Error fetching:', error));
    }, []);

    useEffect(() => {
        if (!searchTerm) {
            setFilteredVac(vac);
        } else {
            const filtered = vac.filter(item =>
                item.header.toLowerCase().includes(searchTerm.toLowerCase())
            );
            setFilteredVac(filtered);
        }
    }, [searchTerm, vac]);

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
                                <Button className="w-100"><NavLink to='/news/create'>Создать новость</NavLink></Button>
                            </div>
                        </div>
                        <div className="row row-cols-lg-3 row-cols-md-2 g-4">
                            {Array.isArray(filteredVac) ? filteredVac.map((f, index) => (
                                <div className="col" key={index}>
                                    <div className="card">
                                        <img src={card_img} className="card-img-top" alt="" />
                                        <div className="card-body">
                                            <h5 className="card-title">{f.header}</h5>
                                            <p className="card-text">{f.textBody}</p>
                                            <div className="d-flex gap-2 flex-wrap mb-3">
                                                {f.tags.map(t => (
                                                    <p key={t.id} className="m-0 badge">{t.name}</p>
                                                ))}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            )) : null}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default News;
