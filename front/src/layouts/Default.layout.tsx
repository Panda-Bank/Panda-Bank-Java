import { ReactNode } from 'react'
import { Footer, NavBar } from '../components'

type props = { children: ReactNode, variant?: string }

export function DefaultLayout({ children, variant }: props) {
    return variant != "nofooter" ? (
        <main className='page_wrapper bg-white'>
            <NavBar />
            <main className='default-main'>
                {children}
            </main>
            <Footer />
        </main>
    ) : (
        <main className='page_wrapper bg-white'>
            <NavBar />
            <main className='default-main'>
                {children}
            </main>
        </main>
    )
}