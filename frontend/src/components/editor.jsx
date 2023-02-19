import { CKEditor } from "@ckeditor/ckeditor5-react";
import ClassicEditor from '@ckeditor/ckeditor5-editor-classic/src/classiceditor';
import Alignment from '@ckeditor/ckeditor5-alignment/src/alignment.js';
import Autoformat from '@ckeditor/ckeditor5-autoformat/src/autoformat.js';
import AutoImage from '@ckeditor/ckeditor5-image/src/autoimage.js';
import AutoLink from '@ckeditor/ckeditor5-link/src/autolink.js';
import BlockQuote from '@ckeditor/ckeditor5-block-quote/src/blockquote.js';
import Bold from '@ckeditor/ckeditor5-basic-styles/src/bold.js';
import Code from '@ckeditor/ckeditor5-basic-styles/src/code.js';
import CodeBlock from '@ckeditor/ckeditor5-code-block/src/codeblock.js';
import Essentials from '@ckeditor/ckeditor5-essentials/src/essentials.js';
import FindAndReplace from '@ckeditor/ckeditor5-find-and-replace/src/findandreplace.js';
import FontBackgroundColor from '@ckeditor/ckeditor5-font/src/fontbackgroundcolor.js';
import FontColor from '@ckeditor/ckeditor5-font/src/fontcolor.js';
import FontFamily from '@ckeditor/ckeditor5-font/src/fontfamily.js';
import FontSize from '@ckeditor/ckeditor5-font/src/fontsize.js';
import GeneralHtmlSupport from '@ckeditor/ckeditor5-html-support/src/generalhtmlsupport.js';
import Heading from '@ckeditor/ckeditor5-heading/src/heading.js';
import Highlight from '@ckeditor/ckeditor5-highlight/src/highlight.js';
import HorizontalLine from '@ckeditor/ckeditor5-horizontal-line/src/horizontalline.js';
import HtmlEmbed from '@ckeditor/ckeditor5-html-embed/src/htmlembed.js';
import Image from '@ckeditor/ckeditor5-image/src/image.js';
import ImageCaption from '@ckeditor/ckeditor5-image/src/imagecaption.js';
import ImageInsert from '@ckeditor/ckeditor5-image/src/imageinsert.js';
import ImageResize from '@ckeditor/ckeditor5-image/src/imageresize.js';
import ImageStyle from '@ckeditor/ckeditor5-image/src/imagestyle.js';
import ImageToolbar from '@ckeditor/ckeditor5-image/src/imagetoolbar.js';
import ImageUpload from '@ckeditor/ckeditor5-image/src/imageupload.js';
import Indent from '@ckeditor/ckeditor5-indent/src/indent.js';
import IndentBlock from '@ckeditor/ckeditor5-indent/src/indentblock.js';
import Italic from '@ckeditor/ckeditor5-basic-styles/src/italic.js';
import Link from '@ckeditor/ckeditor5-link/src/link.js';
import LinkImage from '@ckeditor/ckeditor5-link/src/linkimage.js';
import List from '@ckeditor/ckeditor5-list/src/list.js';
import ListProperties from '@ckeditor/ckeditor5-list/src/listproperties.js';
import MediaEmbed from '@ckeditor/ckeditor5-media-embed/src/mediaembed.js';
import MediaEmbedToolbar from '@ckeditor/ckeditor5-media-embed/src/mediaembedtoolbar.js';
import Mention from '@ckeditor/ckeditor5-mention/src/mention.js';
import PageBreak from '@ckeditor/ckeditor5-page-break/src/pagebreak.js';
import Paragraph from '@ckeditor/ckeditor5-paragraph/src/paragraph.js';
import SourceEditing from '@ckeditor/ckeditor5-source-editing/src/sourceediting.js';
import SpecialCharacters from '@ckeditor/ckeditor5-special-characters/src/specialcharacters.js';
import SpecialCharactersArrows from '@ckeditor/ckeditor5-special-characters/src/specialcharactersarrows.js';
import SpecialCharactersCurrency from '@ckeditor/ckeditor5-special-characters/src/specialcharacterscurrency.js';
import SpecialCharactersEssentials from '@ckeditor/ckeditor5-special-characters/src/specialcharactersessentials.js';
import SpecialCharactersMathematical from '@ckeditor/ckeditor5-special-characters/src/specialcharactersmathematical.js';
import Strikethrough from '@ckeditor/ckeditor5-basic-styles/src/strikethrough.js';
import Style from '@ckeditor/ckeditor5-style/src/style.js';
import Subscript from '@ckeditor/ckeditor5-basic-styles/src/subscript.js';
import Superscript from '@ckeditor/ckeditor5-basic-styles/src/superscript.js';
import Table from '@ckeditor/ckeditor5-table/src/table.js';
import TableCaption from '@ckeditor/ckeditor5-table/src/tablecaption.js';
import TableCellProperties from '@ckeditor/ckeditor5-table/src/tablecellproperties';
import TableColumnResize from '@ckeditor/ckeditor5-table/src/tablecolumnresize.js';
import TableProperties from '@ckeditor/ckeditor5-table/src/tableproperties';
import TableToolbar from '@ckeditor/ckeditor5-table/src/tabletoolbar.js';
import TextTransformation from '@ckeditor/ckeditor5-typing/src/texttransformation.js';
import Title from '@ckeditor/ckeditor5-heading/src/title.js';
import TodoList from '@ckeditor/ckeditor5-list/src/todolist';
import Underline from '@ckeditor/ckeditor5-basic-styles/src/underline.js';
import WordCount from '@ckeditor/ckeditor5-word-count/src/wordcount.js';
import FileRepository from "@ckeditor/ckeditor5-upload/src/filerepository";
import '@ckeditor/ckeditor5-build-classic/build/translations/ko';
import '@ckeditor/ckeditor5-heading/build/translations/ko';
import '@ckeditor/ckeditor5-basic-styles/build/translations/ko';
import '@ckeditor/ckeditor5-table/build/translations/ko';
import '@ckeditor/ckeditor5-list/build/translations/ko';
import '@ckeditor/ckeditor5-word-count/build/translations/ko';
import '@ckeditor/ckeditor5-special-characters/build/translations/ko';
import '@ckeditor/ckeditor5-source-editing/build/translations/ko';
import '@ckeditor/ckeditor5-page-break/build/translations/ko';
import '@ckeditor/ckeditor5-link/build/translations/ko';
import '@ckeditor/ckeditor5-media-embed/build/translations/ko';
import '@ckeditor/ckeditor5-image/build/translations/ko';
import '@ckeditor/ckeditor5-font/build/translations/ko';
import '@ckeditor/ckeditor5-horizontal-line/build/translations/ko';
import '@ckeditor/ckeditor5-html-embed/build/translations/ko';
import '@ckeditor/ckeditor5-code-block/build/translations/ko';
import '@ckeditor/ckeditor5-block-quote/build/translations/ko';
import '@ckeditor/ckeditor5-alignment/build/translations/ko';
import '@ckeditor/ckeditor5-find-and-replace/build/translations/ko';
import '@ckeditor/ckeditor5-style/build/translations/ko';
import Viewer from "./view";
import { useState } from "react";
import axios from "axios";

const editorConfiguration  = {

};

const Editor = () => {
    // const [flag, setFlag] = useState(false);
    const [content, setContent] = useState('');
    const imgLink = "http://localhost:8080/uploads";

    const customUploadAdapter = (loader) => {
        return {
            upload(){
                return new Promise ((resolve, reject) => {
                    const data = new FormData();
                     loader.file.then( (file) => {
                            data.append("name", file.name);
                            data.append("file", file);

                            axios.post('/api/upload', data)
                                .then((res) => {
                                    // if(!flag){
                                    //     setFlag(true);
                                    //     setImage(res.data.filename);
                                    // }
                                    console.log(res);
                                    resolve({
                                        default: res.data
                                    });
                                })
                                .catch((err)=>reject(err));
                        })
                })
            }
        }
    }

    function uploadPlugin (editor){
        editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
            return customUploadAdapter(loader);
        }
    }

    return (
        <div className="blogCard shadow-sm bg-body rounded" style={{width:"100%"}}>
            <div className="editorContainer">
                <CKEditor
                    editor={ ClassicEditor }
                    // onReady={(editor) => {
                    //     editor.ui
                    //     .getEditableElement()
                    //     .parentElement.insertBefore(
                    //     editor.ui.view.toolbar.element,
                    //     editor.ui.getEditableElement()
                    //     );
                    // }}
                    config={{
                        language: "ko",
                        placeholder : "본문 내용을 입력해주세요.",
                        mediaEmbed: {
                            previewsInData: true
                        },
                        shouldNotGroupWhenFull: false,
                        plugins: [
                            Alignment,
                            Autoformat,
                            AutoImage,
                            AutoLink,
                            BlockQuote,
                            Bold,
                            Code,
                            CodeBlock,
                            Essentials,
                            FindAndReplace,
                            FontBackgroundColor,
                            FontColor,
                            FontFamily,
                            FontSize,
                            GeneralHtmlSupport,
                            Heading,
                            Highlight,
                            HorizontalLine,
                            HtmlEmbed,
                            Image,
                            ImageCaption,
                            ImageInsert,
                            ImageResize,
                            ImageStyle,
                            ImageToolbar,
                            ImageUpload,
                            Indent,
                            IndentBlock,
                            Italic,
                            Link,
                            LinkImage,
                            List,
                            ListProperties,
                            MediaEmbed,
                            MediaEmbedToolbar,
                            Mention,
                            PageBreak,
                            Paragraph,
                            SourceEditing,
                            SpecialCharacters,
                            SpecialCharactersArrows,
                            SpecialCharactersCurrency,
                            SpecialCharactersEssentials,
                            SpecialCharactersMathematical,
                            Strikethrough,
                            Style,
                            Subscript,
                            Superscript,
                            Table,
                            TableCaption,
                            TableCellProperties,
                            TableColumnResize,
                            TableProperties,
                            TableToolbar,
                            TextTransformation,
                            Title,
                            TodoList,
                            Underline,
                            WordCount,
                            FileRepository
                        ],
                        toolbar: {
                            items: [
                                'heading',
                                '|',
                                'bold',
                                'italic',
                                'underline',
                                'strikethrough',
                                'fontFamily',
                                'fontSize',
                                'fontColor',
                                'fontBackgroundColor',
                                '|',
                                'bulletedList',
                                'numberedList',
                                'todoList',
                                '|',
                                'outdent',
                                'indent',
                                '|',
                                'findAndReplace',
                                'undo',
                                'redo',
                                '-',
                                'style',
                                '|',
                                'alignment',
                                '|',
                                'horizontalLine',
                                'blockQuote',
                                'code',
                                'codeBlock',
                                '|',
                                'subscript',
                                'superscript',
                                'specialCharacters',
                                '|',
                                'link',
                                'imageUpload',
                                'insertTable',
                                'mediaEmbed',
                                '|',
                                'htmlEmbed',
                                'pageBreak',
                                'sourceEditing'
                            ],
                            shouldNotGroupWhenFull: true
                        },
                        heading: {
                            options: [
                                {
                                    model: "paragraph",
                                    view: "p",
                                    title: "본문",
                                    class: "ck-heading_paragraph",
                                },
                                {
                                    model: "heading1",
                                    view: "h1",
                                    title: "헤더1",
                                    class: "ck-heading_heading1",
                                },
                                {
                                    model: "heading2",
                                    view: "h2",
                                    title: "헤더2",
                                    class: "ck-heading_heading2",
                                },
                                {
                                    model: "heading3",
                                    view: "h3",
                                    title: "헤더3",
                                    class: "ck-heading_heading3",
                                },
                            ],
                        },
                        fontSize: {
                            options: [
                                14,
                                15,
                                16,
                                17,
                                18,
                                19,
                                20,
                                21,
                                22,
                                23,
                                24,
                                25,
                                26,
                                27,
                                28,
                                29,
                                30,
                            ],
                        },
                        alignment: {
                            options: ["justify", "left", "center", "right"],
                        },
                        table: {
                            contentToolbar: [
                                'tableColumn',
                                'tableRow',
                                'mergeTableCells',
                                'tableCellProperties',
                                'tableProperties'
                            ],
                        },
                        image: {
                            resizeUnit: "px",
                            toolbar: [
                                "imageStyle:alignLeft",
                                "imageStyle:full",
                                "imageStyle:alignRight",
                                "|",
                                "imageTextAlternative",
                                'toggleImageCaption',
                                'linkImage'
                            ],
                            styles: ["full", "alignLeft", "alignRight"],
                            type: ["JPEG", "JPG", "GIF", "PNG"],
                        },
                        typing: {
                            transformations: {
                                remove: [
                                    "enDash",
                                    "emDash",
                                    "oneHalf",
                                    "oneThird",
                                    "twoThirds",
                                    "oneForth",
                                    "threeQuarters",
                                ],
                            },
                        },
                        style: {
                            definitions: [
                                {
                                    name: 'Side quote',
                                    element: 'blockquote',
                                    classes: [ 'side-quote' ]
                                },
                                {
                                    name: 'Spoiler',
                                    element: 'span',
                                    classes: [ 'spoiler' ]
                                },
                            ]
                        },
                        extraPlugins: [uploadPlugin]
                    }}
                    onChange={(event, editor) => {
                        const data = editor.getData();
                        setContent(data);
                        console.log({ event, editor, data });
                    }}
                />
            </div>
            <Viewer content={content}/>
        </div>
    );
}

export default Editor;