import JournalList from "./journal-content/journal-list";
import JournalFormEditor from "./journal-content/journal-form-editor";
import ArticleList from "./journal-content/journal-articles-list";
const {HashRouter, Route} = window.ReactRouterDOM; 
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/journals", "/"]} exact={true}>
                    <JournalList/>
                </Route>
                <Route path="/journals/:id" exact={true}>
                    <JournalFormEditor/>
                </Route>
                <Route path="/journals/:id/articles" exact={true}>
                    <ArticleList/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
