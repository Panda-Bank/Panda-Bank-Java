import { CardProps } from "../../libs/types"
import { handleChangePage } from "../../libs/tools"

export function Card({ title, children, text }: CardProps) {

    return (

        <div className="max-w-sm bg-white border border-gray-200 rounded-lg shadow-md dark:bg-gray-800 dark:border-gray-700">
            <>
                {children}
            </>
            <div className="p-5">
                <>
                    <h5 className="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">{title}</h5>
                </>
                <p className="mb-3 font-normal text-gray-700 dark:text-gray-400">{text}</p>
                <button onClick={() => handleChangePage('register')} className="inline-flex items-center px-3 py-2 text-sm font-medium text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                    Conheça
                </button>
            </div>
        </div>

    )
}