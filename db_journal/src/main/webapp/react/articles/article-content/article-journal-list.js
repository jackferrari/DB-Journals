const {Link,useHistory} = window.ReactRouterDOM;

import journalService from "./journal-service"
const { useState, useEffect } = React;
const JournalList = () => {
    const [journals, setJournals] = useState([])
    useEffect(() => {
        findAllJournals()
    }, [])
    const findAllJournals = () =>
        journalService.findAllJournals()
            .then(journals => setJournals(journals))
    return(
        <div>
            <h2>Journal of This Article</h2>
            <ul className="list-group">
                {
                    journals.map(journal =>
                        <li className="btn" key={journal.id}>
                            <Link className="btn btn-light btn-block" to={`/journals/${journal.id}`}>
                                {journal.name}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default JournalList;
