import { EButton } from "../Button";

export function Footer() {

    return <footer className='footer'>

        <div className="flex">
            <EButton variant="secondary">Panda Group</EButton>
        </div>

        <span>
            <ul>
                <li><a href='#'>Contato Designer</a></li>
                <li><a href='#'>Sobre</a></li>
                <li><a href='#'>Contato reclamação</a></li>
                <li><a href='#'>Vagas</a></li>
            </ul>
        </span>
    </footer>
}